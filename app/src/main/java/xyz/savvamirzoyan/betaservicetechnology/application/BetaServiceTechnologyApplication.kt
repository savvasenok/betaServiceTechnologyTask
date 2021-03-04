package xyz.savvamirzoyan.betaservicetechnology.application

import android.app.Application
import timber.log.Timber

class BetaServiceTechnologyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}