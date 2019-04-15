package dk.nodes.template.presentation.ui.solitaire

import lucassales.com.FoundationPile
import lucassales.com.TableauPile
import om.lucassales.Card
import om.lucassales.Deck

data class SolitaireViewState(
    val deck: Deck,
    val wastePile: List<Card>,
    val foundationPiles: List<FoundationPile>,
    val tableauPiles: List<TableauPile>
)