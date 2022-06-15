package hare.krshna.numerology.numerology

class NumerologyImpl(private val map: Map<Char, Int>) : Numerology {
  override fun computeValue(name: String): Int {
    return detectFinalValue(name.map { map[it]!! }.sum())
  }

  private fun detectFinalValue(arg: Int): Int {
    if (arg.toString().length == 1) {
      return arg
    }
    return detectFinalValue(arg.toString().map { it.toString().toInt() }.sum())
  }
}