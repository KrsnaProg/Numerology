package hare.krshna.numerology.domain.useCases

import com.zuluft.api.usecases.BaseUseCase
import hare.krshna.numerology.database.DataBase
import hare.krshna.numerology.domain.models.SearchHistoryModel
import io.reactivex.Observable

class GetSearchHistoryUseCase(
    private val database: DataBase
) : BaseUseCase<Unit, Observable<List<SearchHistoryModel>>> {

    override fun invoke(arg: Unit?): Observable<List<SearchHistoryModel>> {
        return database.searchHistoryDao().selectAll().toObservable()
    }
}
