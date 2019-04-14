package om.lucassales

data class Deck(val rules: Rules) {

    private val cards = Array(rules.validFigures.size * rules.validSuits.size) {
        val suit = rules.validSuits[it / rules.validFigures.size]
        val figure = rules.validFigures[it % rules.validFigures.size]
        Card(
            figure,
            suit,
            rules.cardValue(figure to suit)
        )
    }
    var cardsInDeck = cards.toMutableList().apply { shuffle() }

    fun reset() {
        cardsInDeck.clear()
        cardsInDeck.addAll(cards)
        cardsInDeck.shuffle()
    }

    fun drawCard() = cardsInDeck.removeAt(0)

    private fun bodyString(): String {
        return cards.toList().onEach{
            it.faceUp = true
        }.joinToString { it.toString() }
    }

    override fun toString(): String {
        return bodyString()
    }

    fun printDebug() {
        cardsInDeck.forEach(::print)
    }
}