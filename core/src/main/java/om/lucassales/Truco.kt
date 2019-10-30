package om.lucassales

import javax.inject.Inject

class Truco @Inject constructor(
    private val rules: TrucoRules,
    val deck: Deck
) {

    private val _players = mutableListOf<Player>()
    val players : List<Player> = _players
    private val cardsOnPile = mutableListOf<PlayerCard>()

    private val rounds = mutableListOf<Round>()

    private val playerNames = listOf("Lucas", "Gustavo", "Ricardo", "Tiago")
    val teamA = listOf(playerNames[0], playerNames[2])
    val teamB = listOf(playerNames[1], playerNames[3])

    fun newMatch() {
        rounds.clear()
    }

    fun newRound(): Round {
        deck.reset()
        rules.resetWithDeck(deck)
        _players.clear()
        for (i in 0 until rules.playerCount) {
            _players += Player(Hand(deck, rules), playerNames[i])
        }
        return Round(rules).also { rounds += it }
    }

    fun newTurn(round: Round): Turn {
        val list = mutableListOf<PlayerCard>()
        players.forEach { player ->
            list += PlayerCard(player, player.hand.popCardAt(0).copy(faceUp = true))
        }
        return Turn(list).also { round.turns += it }
    }

    fun logPile() {
        println("Pile:")
        println("*********")
        cardsOnPile.forEach {
            it.card.faceUp = true
            println("Player ${it.player.name}")
            println(it.card.logString)
            println("--------")
        }
        println("*********")
    }
}