package dk.nodes.template.presentation.ui.solitaire

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dk.nodes.template.injection.ViewModelKey

@Module
abstract class SolitaireActivityBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(SolitaireViewModel::class)
    abstract fun bindViewModel(viewModel: SolitaireViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun solitaireActivity(): SolitaireActivity
}