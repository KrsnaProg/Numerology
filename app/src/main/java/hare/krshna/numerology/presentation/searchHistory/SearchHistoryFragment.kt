package hare.krshna.numerology.presentation.searchHistory

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zuluft.api.controllers.fragments.BaseFragment
import hare.krshna.numerology.databinding.FragmentSearchHistoryBinding
import hare.krshna.numerology.presentation.searchHistory.adapter.SearchHistoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchHistoryFragment: BaseFragment<SearchHistoryViewState,SearchHistoryViewModel>() {
    private val viewModel by viewModel<SearchHistoryViewModel>()
    lateinit var binding: FragmentSearchHistoryBinding
    override fun prepareView() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvSearchHistory.layoutManager = layoutManager
    }

    override fun reflectState(state: SearchHistoryViewState) {
        Log.d("Luka", state.toString())
        if (state.history != null){
            binding.rvSearchHistory.adapter = SearchHistoryAdapter(state.history)
        }
    }

    override fun provideViewModel(): SearchHistoryViewModel {
        return viewModel
    }

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = FragmentSearchHistoryBinding.inflate(inflater, container,false)
        return binding.root
    }

    companion object {
        const val TAG = "SearchHistoryFragmentTAG"
        fun newInstance(): SearchHistoryFragment {
            return SearchHistoryFragment()
        }
    }
}