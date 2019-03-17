package om.lucassales

interface Rules {
    val validFigures: List<Figure>
    val validSuits: List<Suit>
    val handLengh: Int
    val playerCount: Int

    fun cardValue(pair: Pair<Figure, Suit>): Int
}