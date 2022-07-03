package hare.krshna.numerology.presentation.textInput

import com.zuluft.api.viewModels.BaseViewModel
import hare.krshna.numerology.domain.models.SearchHistoryModel
import hare.krshna.numerology.domain.useCases.CashSearchHistoryUseCase
import hare.krshna.numerology.numerology.Numerology
import io.reactivex.schedulers.Schedulers

class TextInputViewModel(
    private val numerology: Numerology,
    private val cashSearchHistoryUseCase: CashSearchHistoryUseCase
) : BaseViewModel<TextInputViewState>() {

    fun onConfirmClicked(text: String) {
        onGetNumericalImageIntent(text)
    }

    private fun onGetBasicValueIntent(text: String) {
        val result = numerology.computeValue(text)
        setState(
            constructState {
                copy(showResult = result.toString())
            }
        )
    }

    private fun onGetHiddenValueIntent(text: String) {
        val result = numerology.computeHiddenValue(text)
        setState(
            constructState {
                copy(showResult = result.toString())
            }
        )
    }

    private fun onGetRidOfFirstLetterIntent(text: String) {
        val result = numerology.getRidOfFirstLetterComputeValue(text)
        setState(
            constructState {
                copy(showResult = result.toString())
            }
        )
    }

    private fun onGetNumericalImageIntent(text: String) {
        val result = numerology.getNumericalImage(text)
        setState(
            constructState {
                copy(showResult = result)
            }
        )
        cashCurrentSearch(result, text)
    }

    private fun cashCurrentSearch(result: String, text: String) {
        val s = SearchHistoryModel(textNumber = result, text = text)
        cashSearchHistoryUseCase.invoke(s).subscribeOn(Schedulers.io()).subscribe()
    }

    override fun getInitialState(): TextInputViewState {
        return TextInputViewState()
    }

}