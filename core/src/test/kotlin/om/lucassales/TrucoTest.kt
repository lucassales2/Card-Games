package om.lucassales

import org.junit.Test

class TrucoTest {
    @Test
    fun testRound() {
        val rules = TrucoRules()
        val deck = Deck(rules)
        val truco = Truco(rules, deck)
        truco.newMatch()
        val round1 = truco.newRound()

        for (i in 0 until 3) {
            val turn = truco.newTurn(round1)
            turn.logTurn()
            val name = turn.determineWinner().name
            println("Winner = $name")

        }

//        truco.players.forEach { it.logPlayer() }
//        rules.logTurnCard()
//        truco.play()
//        truco.logPile()
//        println("Winner = ${truco.winner()}")
//
//        truco.players.forEach { it.logPlayer() }
//        rules.logTurnCard()
//        truco.play()
//        truco.logPile()
//        println("Winner = ${truco.winner()}")
//
//        truco.players.forEach { it.logPlayer() }
//        rules.logTurnCard()
//        truco.play()
//        truco.logPile()
//        println("Winner = ${truco.winner()}")
    }
}