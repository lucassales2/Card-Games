package dk.nodes.template.injection.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dk.nodes.template.injection.DaggerViewModelFactory
import dk.nodes.template.presentation.ui.main.MainActivityBuilder
import dk.nodes.template.presentation.ui.solitaire.SolitaireActivityBuilder

@Module(
    includes = [
        MainActivityBuilder::class,
        SolitaireActivityBuilder::class
    ]
)
internal abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}