package dk.nodes.template.presentation.ui.main

import android.os.Bundle
import dk.nodes.template.R
import dk.nodes.template.domain.models.Post
import dk.nodes.template.presentation.base.BaseActivity
import dk.nodes.template.util.observeEvent
import dk.nodes.template.util.observeNonNull
import timber.log.Timber

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = bindViewModel()
        viewModel.errorLiveData.observeEvent(this, ::showError)
        viewModel.postsLiveData.observeNonNull(this, ::showPosts)
    }

    private fun showPosts(posts: List<Post>) {
        for (post in posts) {
            Timber.e(post.toString())
        }
    }

    private fun showError(msg: String) {
        Timber.e(msg)
    }
}
