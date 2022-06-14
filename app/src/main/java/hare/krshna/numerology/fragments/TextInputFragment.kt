package hare.krshna.numerology.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hare.krshna.numerology.databinding.FragmentTextInputBinding

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

  companion object {
    const val TAG = "TextInputFragmentTAG"
  }

}