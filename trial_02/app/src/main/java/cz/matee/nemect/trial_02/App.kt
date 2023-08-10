package cz.matee.nemect.trial_02

import android.app.Application
import cz.matee.nemect.trial_02.core.di.coreModule
import cz.matee.nemect.trial_02.navigation.NavigationManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(coreModule)
        }
    }
}