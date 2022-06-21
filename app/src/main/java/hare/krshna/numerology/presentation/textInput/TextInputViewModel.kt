package hare.krshna.numerology.presentation.textInput

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hare.krshna.numerology.numerology.Numerology

class TextInputViewModel(
  private val numerology: Numerology
) : ViewModel() {

  val statesLiveData: MutableLiveData<TextInputViewState> = MutableLiveData()

  fun onTextInputIntent(text: String) {
    val result = numerology.computeValue(text)
    val targetState = TextInputViewState(showResult = result.toString())
    statesLiveData.postValue(targetState)
  }
}