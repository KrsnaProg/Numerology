package hare.krshna.numerology.parsers.jsonParce

interface jsonParce {
    fun parceJson(jsonString: String): Map<Char, Int>
}