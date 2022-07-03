package hare.krshna.numerology.presentation.searchHistory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hare.krshna.numerology.databinding.ItemSearchHistoryBinding
import hare.krshna.numerology.domain.models.SearchHistoryModel

class SearchHistoryAdapter(
    private val searchHistory: List<SearchHistoryModel>
) : RecyclerView.Adapter<SearchHistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSearchHistoryBinding.inflate(inflater, parent, false)
        return SearchHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
        val currentSearch = searchHistory[position]
        holder.binding.tvSearchHistoryText.text = currentSearch.text
        holder.binding.tvSearchHistoryTextNumber.text = currentSearch.textNumber
    }

    override fun getItemCount(): Int {
        return searchHistory.size
    }
}