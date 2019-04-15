package lucassales.com

import om.lucassales.Figure
import om.lucassales.Rules
import om.lucassales.Suit

object SolitaireRule : Rules {
    override val validFigures: List<Figure> = Figure.all()
    override val validSuits: List<Suit> = Suit.all()
    override val handLengh: Int
        get() = 0
    override val playerCount = 1

    override fun cardValue(pair: Pair<Figure, Suit>): Int {
        return pair.first.value - 1
    }

//    private val Suit.value
//        get() = weight * 100

    private val Figure.value: Int
        get() = when (this) {
            Figure.ACE -> 1
            Figure.TWO -> 2
            Figure.THREE -> 3
            Figure.FOUR -> 4
            Figure.FIVE -> 5
            Figure.SIX -> 6
            Figure.SEVEN -> 7
            Figure.EIGHT -> 8
            Figure.NINE -> 9
            Figure.TEN -> 10
            Figure.JACK -> 11
            Figure.QUEEN -> 12
            Figure.KING -> 13
        }
}