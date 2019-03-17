package om.lucassales

import org.junit.Test

class TrucoTest {
    @Test
    fun testRound() {
        val rules = TrucoRules()
        val deck = Deck(rules)
        val truco = Truco(rules, deck)
        truco.newRound()
        truco.players.forEach { it.hand.logHand() }
        rules.logTurnCard()
        truco.play()
        truco.logPile()
        println("Winner = ${truco.winner()}")
    }
}