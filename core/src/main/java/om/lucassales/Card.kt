package om.lucassales

data class Card(val figure: Figure, val suit: Suit, var value: Int, var faceUp: Boolean = true) {
    fun asPair() = figure to suit

    val logString: String
        get() {
            return if (faceUp) {
                "[${figure.asciiSymbol} - ${suit.asciiSymbol}]"
            } else {
                "[* - *]"
            }
        }

    override fun toString() = logString
}

fun List<Card>.printDebug() {
    forEach(::print)
}