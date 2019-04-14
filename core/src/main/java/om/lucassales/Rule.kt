package om.lucassales

interface Rule {
    val valid: List<Rule>
    fun previous(vararg previous: Rule): Boolean
    fun next(vararg rules: Rule): Boolean
    val value: Int
}