package hare.krshna.numerology.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hare.krshna.numerology.domain.models.SearchHistoryModel
import io.reactivex.Flowable


@Dao
interface SearchHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(arg: List<SearchHistoryModel>)

    @Query("DELETE FROM search_history")
    fun deleteAll()

    @Query("SELECT * FROM search_history")
    fun selectAll(): Flowable<List<SearchHistoryModel>>
}