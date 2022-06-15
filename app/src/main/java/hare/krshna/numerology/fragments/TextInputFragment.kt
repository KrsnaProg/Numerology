package hare.krshna.numerology.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hare.krshna.numerology.R
import hare.krshna.numerology.databinding.FragmentTextInputBinding
import hare.krshna.numerology.parsers.jsonParcer.RawJsonReaderImpl

class TextInputFragment : Fragment() {
  private lateinit var binding: FragmentTextInputBinding


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentTextInputBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val rawJsonReader = RawJsonReaderImpl(resources)
    val jsonStr = rawJsonReader.readJson(R.raw.numerological_chars_mapping)
    Log.d("zulu", jsonStr)
//    binding.btnConfirm.setOnClickListener {
//      val name = binding.etName.text.toString()
//      val finalAnswer =
//        Toast.makeText(requireContext(), finalAnswer.toString(), Toast.LENGTH_LONG).show()
//    }
  }

  private fun detectFinalValue(arg: Int): Int {
    if (arg.toString().length == 1) {
      return arg
    }
    return detectFinalValue(arg.toString().map { it.toString().toInt() }.sum())
  }

  companion object {
    const val TAG = "TextInputFragmentTAG"
    private val NUMEROLOGICAL_VALUES = arrayOf(
      0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16,
      17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 35, 36
    )
    private val ALPHABET = arrayOf(
      ' ', 'a', 'b', 'g', 'd', 'e', 'v', 'z', 't', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'J',
      'r', 's', 'T', 'u', 'f', 'q', 'R', 'y', 'S', 'C', 'c', 'Z', 'w', 'W', 'x', 'j', 'h'
    )
    val NUMEROLOGICAL_VALUES_DICT = mutableMapOf<Char, Int>()
      .apply {
        NUMEROLOGICAL_VALUES.forEachIndexed { index, i ->
          put(ALPHABET[index], i)
        }
      }
  }

}