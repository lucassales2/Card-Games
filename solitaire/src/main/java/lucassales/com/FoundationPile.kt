package lucassales.com

import om.lucassales.Card
import om.lucassales.Suit

class FoundationPile(val suit: Suit) {
    val cards: MutableList<Card> = mutableListOf()

    fun reset() {
        cards.clear()
    }

    fun removeCard(card: Card) {
        cards.remove(card)
    }

    fun addCard(card: Card): Boolean {
        if (card.suit == suit && card.value == (cards.lastOrNull()?.value?.plus(1) ?: 0)) {
            cards.add(card)
            return true
        }

        return false
    }
}