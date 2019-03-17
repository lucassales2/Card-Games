package om.lucassales

class Deck(private val rules: Rules) {

    private val cards = Array(rules.validFigures.size * rules.validSuits.size) {
        val suit = rules.validSuits[it / rules.validFigures.size]
        val figure = rules.validFigures[it % rules.validFigures.size]
        Card(
            figure,
            suit,
            rules.cardValue(figure to suit)
        )
    }
    private val cardsInDeck = cards.toMutableList().apply { shuffle() }

    fun reset() {
        cardsInDeck.clear()
        cardsInDeck += cards
        cardsInDeck.shuffle()
    }

    fun drawCard() = cardsInDeck.removeAt(0)
}