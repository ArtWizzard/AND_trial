package cz.matee.nemect.trial_02.core.di

import android.app.Application
import cz.matee.nemect.trial_02.App
import cz.matee.nemect.trial_02.core.database.DB
import cz.matee.nemect.trial_02.core.database.profile.ProfileDataSource
import cz.matee.nemect.trial_02.navigation.NavigationManager
import cz.matee.nemect.trial_02.presentation.screens.home.HomeVM
import cz.matee.nemect.trial_02.presentation.screens.home.dictionary.DictionaryScreenVM
import cz.matee.nemect.trial_02.presentation.screens.language.LanguageVM
import cz.matee.nemect.trial_02.presentation.screens.settings.SettingsVM
import cz.matee.nemect.trial_02.presentation.screens.home.test.TestVM
import org.koin.android.ext.koin.androidContext

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val coreModule get() = module {
    // Navigation
    single { NavigationManager() }

    // Database
    single { DB() }
    single { ProfileDataSource(get()) }

    // App
    single { App() }
    single { App().baseContext }

    // View models
    viewModelOf(::SettingsVM)
    viewModelOf(::DictionaryScreenVM)
    viewModelOf(::LanguageVM)
    viewModelOf(::HomeVM)
    viewModelOf(::TestVM)
}