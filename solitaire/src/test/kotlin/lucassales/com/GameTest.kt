package lucassales.com

import om.lucassales.printDebug
import org.junit.Test

class GameTest {
    @Test
    fun kingInFirstFoundationPile() {
        var numGames = 0
        val maxGames = 10000

        for (i in 1..maxGames) {
            numGames++
            Solitaire.reset()
            assert((Solitaire.deck.cardsInDeck.size + Solitaire.foundationPiles.map { it.cards.size }.sum() + Solitaire.tableauPiles.map { it.cards.size }.sum())
                == 52
            )
            for (j in 1..1000) {
                Solitaire.tapDeck()
                while (Solitaire.tapWaste())
                    Solitaire.tableauPiles.forEachIndexed { index, tableauPile ->
                        while (Solitaire.tapTableau(index, tableauPile.cards.lastIndex)) {
                        }
                    }
            }

            if (Solitaire.isComplete()) {
                println("Complete game number   $numGames")
                println("Foundation piles")
                Solitaire.foundationPiles.forEach {
                    println()
                    it.cards.printDebug()
                }

                println()
                println("Deck")
                Solitaire.deck.cardsInDeck.printDebug()
                println("Waste pile")
                Solitaire.wastePile.printDebug()

                Solitaire.tableauPiles.forEach {
                    println("Tableau: ")
                    it.cards.printDebug()
                }

                Solitaire.tableauPiles.forEach {
                    val value = it.cards.isEmpty()
                    if (!value) {
                        Solitaire.tapTableau(it)
                    }
                    assert(value)
                }

                assert(Solitaire.wastePile.isEmpty())
                assert(Solitaire.deck.cardsInDeck.isEmpty())
                println(Solitaire)
                break
            }
        }
        println("Game number $numGames")
        assert(numGames < maxGames)
    }
}