package hare.krshna.numerology.domain.useCases

import com.zuluft.api.usecases.BaseUseCase
import hare.krshna.numerology.database.DataBase
import hare.krshna.numerology.domain.models.SearchHistoryModel
import io.reactivex.Observable

class CashSearchHistoryUseCase(private val dataBase: DataBase) : BaseUseCase<SearchHistoryModel, Observable<Boolean>> {
    override fun invoke(arg: SearchHistoryModel?): Observable<Boolean> {
        return Observable.fromCallable {
            dataBase.searchHistoryDao().insert(listOf(arg!!))
            true
        }
    }
}