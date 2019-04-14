package lucassales.com

import om.lucassales.Card

class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
    init {
        if (cards.size > 0)
            cards.last().faceUp = true
    }

    fun addCards(newCards: List<Card>): Boolean {
        if (cards.size > 0) {
            if (newCards.first().value == cards.last().value - 1 &&
                    suitCheck(newCards.first(), cards.last())) {
                cards.addAll(newCards)
                return true
            }
        } else if (newCards.first().value == 12) {
            cards.addAll(newCards)
            return true
        }

        return false
    }

    fun removeCards(tappedIndex: Int) {
        cards.removeAt(tappedIndex)
        cards.lastOrNull()?.let {
            if (!it.faceUp) it.faceUp = true
        }
    }

    fun suitCheck(card1: Card, card2: Card): Boolean {
        return card1.suit.color != card2.suit.color
    }
}