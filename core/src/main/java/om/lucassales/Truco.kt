package om.lucassales

import javax.inject.Inject

class Truco @Inject constructor(
    private val rules: TrucoRules,
    val deck: Deck
) {

    val players = mutableListOf<Player>()
    val cardsOnPile = mutableListOf<PlayerCard>()

    private val playerNames = listOf("Lucas", "Gustavo", "Ricardo", "Tiago")

    fun newRound() {
        deck.reset()
        rules.resetWithDeck(deck)
        players.clear()
        for (i in 0 until rules.playerCount) {
            players += Player(Hand(deck, rules), playerNames[i])
        }
    }

    fun play() {
        players.forEach { player ->
            cardsOnPile += PlayerCard(player, player.hand.popCardAt(0))
        }
    }

    fun winner(): String {
        var winner = ""
        var strongest = 0
        cardsOnPile.forEach {
            if (it.card.value > strongest) {
                strongest = it.card.value
                winner = it.player.name
            }
        }
        return winner
    }

    fun logPile() {
        println("Pile:")
        println("*********")
        cardsOnPile.forEach {
            println("Player ${it.player.name}")
            println(it.card.logString)
            println("--------")
        }
        println("*********")
    }
}