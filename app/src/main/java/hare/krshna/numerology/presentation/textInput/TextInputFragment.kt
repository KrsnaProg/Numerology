package hare.krshna.numerology.presentation.textInput

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zuluft.api.controllers.fragments.BaseFragment
import hare.krshna.numerology.databinding.FragmentTextInputBinding
import hare.krshna.numerology.presentation.searchHistory.SearchHistoryFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class TextInputFragment : BaseFragment<TextInputViewState, TextInputViewModel>() {
    private lateinit var binding: FragmentTextInputBinding
    private val viewModel by viewModel<TextInputViewModel>()

    override fun prepareView() {
        binding.btnConfirm.setOnClickListener {
            viewModel.onConfirmClicked(binding.etName.text.toString())
        }
    }

    override fun reflectState(state: TextInputViewState) {
        if (state.showResult != null) {
            showResult(state.showResult)
        }
    }

    override fun provideViewModel(): TextInputViewModel {
        return viewModel
    }

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = FragmentTextInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "SearchHistoryFragmentTAG"
        fun newInstance(): SearchHistoryFragment {
            return SearchHistoryFragment()
        }
    }

    private fun showResult(result: String) {
        binding.tvResult.text = result
    }

}