package om.lucassales

import om.lucassales.Figure.ACE
import om.lucassales.Figure.FIVE
import om.lucassales.Figure.FOUR
import om.lucassales.Figure.JACK
import om.lucassales.Figure.KING
import om.lucassales.Figure.QUEEN
import om.lucassales.Figure.SEVEN
import om.lucassales.Figure.SIX
import om.lucassales.Figure.THREE
import om.lucassales.Figure.TWO
import javax.inject.Inject

class TrucoRules @Inject constructor() : Rules {
    var turnCard: Card? = null
        private set

    private val Figure.value: Int
        get() = when (this) {
            is ACE -> 8
            is TWO -> 9
            is THREE -> 10
            is FOUR -> 1
            is FIVE -> 2
            is SIX -> 3
            is SEVEN -> 4
            is JACK -> 5
            is QUEEN -> 6
            is KING -> 7
            else -> throw IllegalArgumentException("InvalidCard")
        }

    override val validFigures: List<Figure>
        get() = listOf(
            ACE,
            TWO,
            THREE,
            FOUR,
            FIVE,
            SIX,
            SEVEN,
            JACK,
            QUEEN,
            KING
        )

    override val validSuits: List<Suit>
        get() = listOf(
            Suit.SPADE,
            Suit.HEART,
            Suit.DIAMOND,
            Suit.CLUB
        )

    override val handLengh: Int = 3

    override fun cardValue(pair: Pair<Figure, Suit>): Int {
        turnCard?.let {
            if (it.figure.isPreviousFrom(pair.first)) {
                return 10 + pair.second.weight
            }
        }
        return pair.first.value
    }

    override val playerCount: Int = 4

    private fun Card.compareTo(other: Card): Int {
        return this.value.compareTo(other.value)
    }

    private operator fun Figure.minus(figure: Figure): Int {
        if (this == FOUR && figure == THREE) return 1
        return figure.value - value
    }

    fun resetWithDeck(deck: Deck) {
        turnCard = deck.drawCard().copy(faceUp = true)
    }

    fun logTurnCard() {
        turnCard?.let {
            println()
            println("Turn Card: ${it.logString}")
            println()
        }
    }
}

private fun Figure.isPreviousFrom(figure: Figure): Boolean {
    return when {
        this is ACE && figure is TWO -> true
        this is TWO && figure is THREE -> true
        this is THREE && figure is FOUR -> true
        this is FOUR && figure is FIVE -> true
        this is FIVE && figure is SIX -> true
        this is SIX && figure is SEVEN -> true
        this is SEVEN && figure is QUEEN -> true
        this is QUEEN && figure is JACK -> true
        this is JACK && figure is KING -> true
        this is KING && figure is ACE -> true
        else -> return false
    }
}
