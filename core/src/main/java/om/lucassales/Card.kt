package om.lucassales

data class Card(val figure: Figure, val suit: Suit, var value: Int) {
    fun asPair() = figure to suit
    val logString: String
        get() {
            return "${figure.asciiSymbol} - [${suit.asciiSymbol}]"
        }
}