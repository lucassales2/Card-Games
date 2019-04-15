package dk.nodes.template.presentation.ui.solitaire

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import dk.nodes.template.R
import dk.nodes.template.presentation.base.BaseActivity
import dk.nodes.template.util.observe
import kotlinx.android.synthetic.main.activity_solitaire.*
import lucassales.com.FoundationPile
import lucassales.com.TableauPile

@SuppressLint("Registered")
class SolitaireActivity : BaseActivity() {
    private lateinit var viewModel: SolitaireViewModel
    private lateinit var controller: SolitaireEpoxyController

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_solitaire)
        viewModel = bindViewModel()
        controller = SolitaireEpoxyController(object : SolitaireEpoxyController.Callback {
            override fun onDeckClick() {
                viewModel.onDeckClick()
            }

            override fun onWastePileClick() {
                viewModel.onWastePileClick()
            }

            override fun onFoundationPileClick(foundationPile: FoundationPile) {
                viewModel.onFoundationPileClick(foundationPile)
            }

            override fun onTableauPileClick(tableauPile: TableauPile) {
                viewModel.onTableauPileClick(tableauPile)
            }
        })
        epoxyRv.setController(controller)
        viewModel.viewState.observe(this, controller::setData)
    }
}