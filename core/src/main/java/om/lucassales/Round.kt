package om.lucassales

data class Round(
    val rules: TrucoRules,
    val turns: MutableList<Turn> = mutableListOf(),
    val value: Int = 1
)