package om.lucassales

import javax.inject.Inject

class Hand @Inject constructor(deck: Deck, rule: Rules) {

    private val _cards = mutableListOf<Card>()
    val cards: List<Card> = _cards

    init {
        _cards.clear()
        for (i in 0 until rule.handLengh) {
            val drawCard = deck.drawCard()
            drawCard.value = rule.cardValue(drawCard.asPair())
            _cards += drawCard
        }
    }

    fun logHand() {
        println("------------")
        cards.forEach {
            println("${it.logString}: ${it.value}")
        }
        println("------------")
    }

    fun popCardAt(position: Int): Card = _cards.removeAt(position)
}