package cz.matee.nemect.trial_02.core.di

import cz.matee.nemect.trial_02.core.database.DB
import cz.matee.nemect.trial_02.navigation.NavigationManager
import cz.matee.nemect.trial_02.presentation.screens.language.LanguageVM
import cz.matee.nemect.trial_02.presentation.screens.home.HomeVM
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val coreModule get() = module {
    // Navigation
    single { NavigationManager() }

    // Database
    single { DB() }

    // View models
    viewModelOf(::LanguageVM)
    viewModelOf(::HomeVM)
}