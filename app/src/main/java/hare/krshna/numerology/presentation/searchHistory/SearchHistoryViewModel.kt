package hare.krshna.numerology.presentation.searchHistory

import com.zuluft.api.extensions.async
import com.zuluft.api.viewModels.BaseViewModel
import hare.krshna.numerology.domain.useCases.GetSearchHistoryUseCase

class SearchHistoryViewModel(
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase
) : BaseViewModel<SearchHistoryViewState>() {

    init {
        fetchSearchHistory()
    }

    private fun fetchSearchHistory() {
        registerDisposables(
            getSearchHistoryUseCase()
                .map {
                    constructState {
                        copy(history = it)
                    }
                }
                .async()
                .subscribe(this::setState)
        )
    }

    fun onSearchHistoryItemClicked() {

    }

    override fun getInitialState(): SearchHistoryViewState {
        return SearchHistoryViewState()
    }
}