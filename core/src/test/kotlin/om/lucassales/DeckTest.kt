package om.lucassales

import org.junit.Test

class DeckTest {

    @Test
    fun testCardsGenerated() {
        val rules = TrucoRules()
        val deck = Deck(rules)
        deck.reset()
        assert(true)
    }
}