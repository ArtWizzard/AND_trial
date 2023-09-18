package cz.matee.nemect.trial_02.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_02.navigation.NavigationManager
import cz.matee.nemect.trial_02.navigation.directions.DictionaryDirections
import cz.matee.nemect.trial_02.navigation.directions.LanguageDirections
import cz.matee.nemect.trial_02.navigation.directions.ProgressDirections
import cz.matee.nemect.trial_02.navigation.directions.TestDirections
import cz.matee.nemect.trial_02.navigation.directions.values.MainStateValue
import cz.matee.nemect.trial_02.navigation.directions.values.TestStateValue

class HomeVM(
    private val navigationManager: NavigationManager
) : ViewModel() {

    val homeState = mutableStateOf( MainStateValue.DICTIONARY )

    fun navigateToLanguage() {
        navigationManager.navigate(LanguageDirections.root)
    }

    fun navigateToDictionary() {
        navigationManager.navigate(DictionaryDirections.dictionary("EN"))
    }

    fun navigateToTest() {
        navigationManager.navigate(TestDirections.test("EN", TestStateValue.MAIN))
    }

    fun navigateToProgress() {
        navigationManager.navigate(ProgressDirections.progress("EN"))
    }
}