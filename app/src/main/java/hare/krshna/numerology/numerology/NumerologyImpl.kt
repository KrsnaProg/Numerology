package hare.krshna.numerology.numerology

class NumerologyImpl(private val map: Map<Char, Int>) : Numerology {
  override fun computeValue(name: String): Int {
    return detectFinalValue(name.map { map[it]!! }.sum())
  }

  override fun computeHiddenValue(name: String): Int {
    return detectFinalValue(name.map{ map[it]!!*(map[it]!!+1) }.sum())
  }

  override fun getRidOfFirstLetterComputeValue(name: String): Int {
    val withoutFirstLetter = name.subSequence(1,name.length).toString()
    return computeValue(withoutFirstLetter)
  }

  override fun getNumericalImage(name: String): String {
    return name.map { map[it] }.toString()
  }

  private fun detectFinalValue(arg: Int): Int {
    if (arg.toString().length == 1) {
      return arg
    }
    return detectFinalValue(arg.toString().map { it.toString().toInt() }.sum())
  }
}