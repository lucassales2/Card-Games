package dk.nodes.template.presentation.ui.solitaire

import com.airbnb.epoxy.TypedEpoxyController
import lucassales.com.FoundationPile
import lucassales.com.TableauPile

class SolitaireEpoxyController(private val callback: Callback) : TypedEpoxyController<SolitaireViewState>() {

    interface Callback {
        fun onDeckClick()

        fun onWastePileClick()

        fun onFoundationPileClick(foundationPile: FoundationPile)

        fun onTableauPileClick(tableauPile: TableauPile)
    }

    override fun buildModels(data: SolitaireViewState?) {
        data?.let {
        }
    }
}