package om.lucassales

data class Turn(val playerCards: List<PlayerCard>) {

    fun determineWinner(): Player {
        var strongest = 0
        var winner: Player? = null
        playerCards.filter { it.card.faceUp }.forEach {
            if (it.card.value > strongest) {
                strongest = it.card.value
                winner = it.player
            }
        }
        return winner ?: throw RuntimeException("no winner")
    }

    fun logTurn() {
        println("Round begin")
        println("--------")

        playerCards.forEach {
            it.card.faceUp = true
            println("Player ${it.player.name}")
            println(it.card.logString)
            println("--------")
        }
        println("--------")
        println("Round end")
    }
}