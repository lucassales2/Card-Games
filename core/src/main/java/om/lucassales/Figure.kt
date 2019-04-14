package om.lucassales

sealed class Figure(val asciiSymbol: Char) {
    object ACE : Figure('A')
    object TWO : Figure('2')
    object THREE : Figure('3')
    object FOUR : Figure('4')
    object FIVE : Figure('5')
    object SIX : Figure('6')
    object SEVEN : Figure('7')
    object EIGHT : Figure('8')
    object NINE : Figure('9')
    object TEN : Figure('T')
    object JACK : Figure('J')
    object QUEEN : Figure('Q')
    object KING : Figure('K')

    companion object {
        fun all() = listOf(
            ACE,
            TWO,
            THREE,
            FOUR,
            FIVE,
            SIX,
            SEVEN,
            EIGHT,
            NINE,
            TEN,
            JACK,
            QUEEN,
            KING
        )
    }
}
