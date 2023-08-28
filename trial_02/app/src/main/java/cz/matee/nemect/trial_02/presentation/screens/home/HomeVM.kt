package cz.matee.nemect.trial_02.presentation.screens.home

import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_02.core.database.DB
import cz.matee.nemect.trial_02.navigation.directions.LanguageDirections
import cz.matee.nemect.trial_02.navigation.NavigationManager
import org.koin.compose.koinInject

class HomeVM(
    private val navigationManager: NavigationManager
) : ViewModel() {

    fun navigateToLanguage() {
        navigationManager.navigate(LanguageDirections.root)
    }
}