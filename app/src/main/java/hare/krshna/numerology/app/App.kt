package hare.krshna.numerology.app

import android.app.Application
import hare.krshna.numerology.di.APP_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin()
  }

  private fun startKoin() {
    startKoin {
      androidContext(this@App)
      modules(
        listOf(
          APP_MODULE
        )
      )
    }
  }
}