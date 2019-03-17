package om.lucassales

enum class Color {
    RED,
    BLACK,
}

/**
 * Order is the same as for corresponding Unicode characters, which probably follows some
 * well-known convention.
 */
enum class Suit(val color: Color, val asciiSymbol: Char, val weight: Int) {
    SPADE(Color.BLACK, 'S', 2),
    HEART(Color.RED, 'H', 3),
    DIAMOND(Color.RED, 'D', 1),
    CLUB(Color.BLACK, 'C', 4);

    companion object {
        fun fromInt(value: Int, validFigureLength: Int): Suit {
            return when(value / validFigureLength) {
                0 -> CLUB
                1 -> DIAMOND
                2 -> HEART
                else -> SPADE
            }
        }
    }
}