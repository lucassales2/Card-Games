package om.lucassales

enum class Color {
    RED,
    BLACK,
}

/**
 * Order is the same as for corresponding Unicode characters, which probably follows some
 * well-known convention.
 */
sealed class Suit(val color: Color, val asciiSymbol: Char, val weight: Int) {
    object SPADE : Suit(Color.BLACK, 'S', 2)
    object HEART : Suit(Color.RED, 'H', 3)
    object DIAMOND : Suit(Color.RED, 'D', 1)
    object CLUB : Suit(Color.BLACK, 'C', 4)

    companion object {
        fun fromInt(value: Int): Suit {
            return when (value) {
                0 -> CLUB
                1 -> DIAMOND
                2 -> HEART
                else -> SPADE
            }
        }

        fun all() =
            listOf(
                SPADE,
                HEART,
                DIAMOND,
                CLUB
            )
    }
}