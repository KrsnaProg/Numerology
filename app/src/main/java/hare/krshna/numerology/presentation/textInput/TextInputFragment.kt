package hare.krshna.numerology.presentation.textInput

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hare.krshna.numerology.databinding.FragmentTextInputBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class TextInputFragment : Fragment() {
  private lateinit var binding: FragmentTextInputBinding

  private val viewModel by viewModel<TextInputViewModel>()

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
    subscribeLiveData()
    binding.btnConfirm.setOnClickListener {
      viewModel.onTextInputIntent(binding.etName.text.toString())
    }
  }

  private fun subscribeLiveData() {
    viewModel.statesLiveData.observe(viewLifecycleOwner) {
      if (it.showResult != null) {
        showResult(it.showResult)
      }
    }
  }

  private fun showResult(result: String) {
    binding.tvResult.text = result
  }

  companion object {
    const val TAG = "TextInputFragmentTAG"
  }
}