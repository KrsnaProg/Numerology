package hare.krshna.numerology.presentation.home

import com.zuluft.api.viewModels.BaseViewModel

class HomeViewModel : BaseViewModel<HomeViewState>() {

    init {
        setState(
            constructState {
                copy(goToTextInputScreen = true)
            }
        )
    }

    fun onTextInputClickIntent() {
        setState(
            constructState {
                copy(
                    goToTextInputScreen = true,
                    goToScannerScreen = false,
                    goToSearchHistoryScreen = false
                )
            }
        )
    }

    fun onScannerClickIntent() {
        setState(
            constructState {
                copy(
                    goToTextInputScreen = false,
                    goToScannerScreen = true,
                    goToSearchHistoryScreen = false
                )
            }
        )
    }

    fun onSearchHistoryClickIntent() {
        setState(
            constructState {
                copy(
                    goToTextInputScreen = false,
                    goToScannerScreen = false,
                    goToSearchHistoryScreen = true
                )
            }
        )
    }

    override fun getInitialState(): HomeViewState {
        return HomeViewState()
    }

}