package dk.nodes.template.presentation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import dk.nodes.template.R
import dk.nodes.template.domain.models.Post
import dk.nodes.template.presentation.base.BaseActivity
import dk.nodes.template.presentation.ui.main.favorites.FavoritesFragment
import dk.nodes.template.presentation.ui.main.search.SearchFragment
import dk.nodes.template.presentation.ui.main.trending.TrendingFragment
import dk.nodes.template.util.observeEvent
import dk.nodes.template.util.observeNonNull
import timber.log.Timber

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var navigationViewModel: MainActivityNavigationViewModel
    private var shownFragment: Fragment? = null
    private val favoritesFragment: FavoritesFragment
        get() = findFragment() ?: FavoritesFragment.newInstance()
    private val searchFragment: SearchFragment
        get() = findFragment() ?: SearchFragment.newInstance()
    private val trendingFragment: TrendingFragment
        get() = findFragment() ?: TrendingFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = bindViewModel()
        navigationViewModel = bindViewModel()
        viewModel.errorLiveData.observeEvent(this, ::showError)
        viewModel.postsLiveData.observeNonNull(this, ::showPosts)
        navigationViewModel.sectionLiveData.observeEvent(this, ::handleNavigation)
        navigationViewModel.openMainSection(MainSection.Trending)
    }

    private fun showPosts(posts: List<Post>) {
        for (post in posts) {
            Timber.e(post.toString())
        }
    }

    private fun showError(msg: String) {
        Timber.e(msg)
    }

    private fun handleNavigation(section: MainSection) {
        val fragment = when (section) {
            MainSection.Trending -> trendingFragment
            MainSection.Search -> searchFragment
            MainSection.Favorites -> favoritesFragment
        }
        if (fragment == shownFragment) return
        while (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        }
        val ft = supportFragmentManager.beginTransaction()

        // We hide/show the fragments normally, add() only once
        if (!fragment.isAdded) {
            ft.add(R.id.fragmentHolderLayout, fragment, fragment::class.simpleName)
        }

        ft.show(fragment)

        // Hide currently shown fragment
        shownFragment?.let(ft::hide)
        ft.commit()

        // Save for later
        shownFragment = fragment
    }

    private inline fun <reified T> findFragment(): T? {
        return supportFragmentManager.findFragmentByTag(T::class.simpleName) as? T
    }
}
