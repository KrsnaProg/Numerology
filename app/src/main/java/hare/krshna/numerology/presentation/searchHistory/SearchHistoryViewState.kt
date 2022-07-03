package hare.krshna.numerology.presentation.searchHistory

import hare.krshna.numerology.domain.models.SearchHistoryModel

data class SearchHistoryViewState(
    val history: List<SearchHistoryModel>? = null
)
