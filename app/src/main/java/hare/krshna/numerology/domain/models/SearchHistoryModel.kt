package hare.krshna.numerology.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "search_history")
data class SearchHistoryModel(
    @PrimaryKey
    @SerializedName("text_number")
    val textNumber : String,
    @SerializedName("text")
    val text : String,
)