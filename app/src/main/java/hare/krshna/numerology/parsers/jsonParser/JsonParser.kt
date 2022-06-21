package hare.krshna.numerology.parsers.jsonParser

interface JsonParser {
  fun parseJson(jsonString: String): Map<Char, Int>
}