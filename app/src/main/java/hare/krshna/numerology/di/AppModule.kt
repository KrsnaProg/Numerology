package hare.krshna.numerology.di

import androidx.room.Room
import com.google.gson.Gson
import hare.krshna.numerology.R
import hare.krshna.numerology.database.DataBase
import hare.krshna.numerology.domain.useCases.CashSearchHistoryUseCase
import hare.krshna.numerology.domain.useCases.GetSearchHistoryUseCase
import hare.krshna.numerology.numerology.Numerology
import hare.krshna.numerology.numerology.NumerologyImpl
import hare.krshna.numerology.parsers.jsonParser.JsonParser
import hare.krshna.numerology.parsers.jsonParser.JsonParserImpl
import hare.krshna.numerology.parsers.jsonReader.RawJsonReader
import hare.krshna.numerology.parsers.jsonReader.RawJsonReaderImpl
import hare.krshna.numerology.presentation.home.HomeViewModel
import hare.krshna.numerology.presentation.searchHistory.SearchHistoryViewModel
import hare.krshna.numerology.presentation.textInput.TextInputViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

private const val NODE_ALPHABET_JSON = "NODE_ALPHABET_JSON"
private const val NODE_ALPHABET_MAP = "NODE_ALPHABET_MAP"
private const val DATABASE_NAME = "DATABASE_NAME"

val APP_MODULE = module {
  single {
    JsonParserImpl(get())
  } bind JsonParser::class

  single {
    androidContext().resources
  }

  single {
    RawJsonReaderImpl(get())
  } bind RawJsonReader::class

  single {
    Gson()
  }

  factory(named(NODE_ALPHABET_JSON)) {
    get<RawJsonReader>().readJson(R.raw.numerological_chars_mapping)
  }

  factory(named(NODE_ALPHABET_MAP)) {
    get<JsonParser>().parseJson(get(named(NODE_ALPHABET_JSON)))
  }

  single {
    NumerologyImpl(get(named(NODE_ALPHABET_MAP)))
  } bind Numerology::class

  viewModel {
    TextInputViewModel(get(), get())
  }

  viewModel {
    HomeViewModel()
  }

  viewModel {
    SearchHistoryViewModel(get())
  }

  factory {
    GetSearchHistoryUseCase(get())
  }

  factory {
    CashSearchHistoryUseCase(get())
  }

  single {
    Room.databaseBuilder(
      androidContext(),
      DataBase::class.java,
      DATABASE_NAME
    ).fallbackToDestructiveMigration()
      .build()
  } bind DataBase::class

}