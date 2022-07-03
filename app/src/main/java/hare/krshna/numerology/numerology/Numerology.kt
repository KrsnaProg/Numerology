package hare.krshna.numerology.numerology

interface Numerology {
  fun computeValue(name: String): Int
  fun computeHiddenValue(name: String): Int
  fun getRidOfFirstLetterComputeValue(name: String): Int
  fun getNumericalImage(name: String): String
}