package om.lucassales

import org.junit.Test

class HandTest {

    @Test
    fun draftHand() {
        val rules = TrucoRules()
        val deck = Deck(rules)

        rules.resetWithDeck(deck)
        println("Turn card: ${rules.turnCard!!.logString}")
        println()
        val hands = mutableListOf<Hand>()
        for (i in 0 until rules.playerCount) {
            val hand = Hand(deck, rules)
            assert(hand.cards.size == 3)
            println("Hand number ${(i + 1)}")
            hand.logHand()
            var strenght = 0
            hand.cards.map { rules.cardValue(it.asPair()) }.forEach {
                strenght += it
            }
            println("Hand strength $strenght")
            println("------------")
            hands += hand
        }
    }

    @Test
    fun pickCardAt() {
    }
}
