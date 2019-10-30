package om.lucassales

data class Player(val hand: Hand, val name: String) {
    fun logPlayer() {
        println("------------")
        println(name)
        hand.logHand()
        println("------------")
    }
}