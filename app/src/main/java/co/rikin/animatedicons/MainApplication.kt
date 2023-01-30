package co.rikin.animatedicons

import android.app.Application
import app.rive.runtime.kotlin.core.Rive

class MainApplication: Application() {
  override fun onCreate() {
    super.onCreate()

    Rive.init(applicationContext)
  }
}