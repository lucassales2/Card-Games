package lucassales.com

import om.lucassales.Card
import om.lucassales.Suit

class FoundationPile(val suit: Suit) {
    private val _cards = mutableListOf<Card>()
    val cards: List<Card> = _cards

    fun reset() {
        _cards.clear()
    }

    fun removeCard(card: Card) {
        _cards.remove(card)
    }

    fun addCard(card: Card): Boolean {
        if (card.suit == suit && card.value == (cards.lastOrNull()?.value?.plus(1) ?: 0)) {
            _cards.add(card)
            return true
        }

        return false
    }
}