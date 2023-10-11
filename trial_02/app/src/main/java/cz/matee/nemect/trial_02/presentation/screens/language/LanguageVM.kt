package cz.matee.nemect.trial_02.presentation.screens.language

import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_02.core.data.LanguageRepository
import cz.matee.nemect.trial_02.navigation.NavigationManager
import cz.matee.nemect.trial_02.navigation.directions.DictionaryDirections

class LanguageVM(
    private val navigationManager: NavigationManager,
    private val languageRepository: LanguageRepository
) : ViewModel() {

//    val _languages = database.provideLanguages()

    fun navigateToDictionary( language: String ) {
        navigationManager.navigate( DictionaryDirections.dictionary(language))    }

    fun addNewUser() {
//        database.addLanguage("French","FR")
        languageRepository.
    }
}