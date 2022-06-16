package hare.krshna.numerology.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import hare.krshna.numerology.databinding.FragmentTextInputBinding
import hare.krshna.numerology.numerology.Numerology
import org.koin.android.ext.android.inject


class TextInputFragment : Fragment() {
  private lateinit var binding: FragmentTextInputBinding

  private val numerology by inject<Numerology>()

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
    binding.btnConfirm.setOnClickListener {
      showToast(binding.etName.text.toString())
    }
  }

  private fun showToast(name: String) {
    Toast.makeText(
      requireContext(),
      numerology.computeValue(name).toString(),
      Toast.LENGTH_LONG
    ).show()
  }

  companion object {
    const val TAG = "TextInputFragmentTAG"
  }
}