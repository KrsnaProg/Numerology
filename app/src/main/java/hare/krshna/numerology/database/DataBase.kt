package hare.krshna.numerology.database

import androidx.room.Database
import androidx.room.RoomDatabase
import hare.krshna.numerology.database.daos.SearchHistoryDao
import hare.krshna.numerology.domain.models.SearchHistoryModel

@Database(
    entities = [
        SearchHistoryModel::class
    ],
    version = 2
)

abstract class DataBase : RoomDatabase() {
    abstract fun searchHistoryDao(): SearchHistoryDao
}