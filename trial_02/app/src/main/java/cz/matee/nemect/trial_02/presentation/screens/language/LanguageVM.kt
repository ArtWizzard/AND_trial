package cz.matee.nemect.trial_02.presentation.screens.language

import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_02.core.database.DB
import cz.matee.nemect.trial_02.navigation.NavigationManager
import cz.matee.nemect.trial_02.navigation.directions.DictionaryDirections

class LanguageVM(
    private val navigationManager: NavigationManager,
    private val database: DB
) : ViewModel() {

    // Testing working
    // ...
    // 1
//    val users = MutableStateFlow<MutableSet<String>>(
//        mutableSetOf( "Tom", "Klarka" )
//    )
    // 2
//    val _users: MutableStateFlow<MutableSet<String>>
//        = MutableStateFlow(mutableSetOf( "Tom", "Klarka" ))
    // 3
//    val users: MutableState<Users>
//    = mutableStateOf( Users( mutableSetOf( "Tom", "Klarka" ) ))
    // 4
//    val users = mutableListOf("Tom", "Klarka")
    // 5
//    val languages = mutableStateListOf("English", "Deutsch")
    val _languages = database.provideLanguages()

    fun navigateToDictionary( language: String ) {
        navigationManager.navigate( DictionaryDirections.dictionary(language))    }

    fun addNewUser() {
        database.addLanguage("French","FR")
    }
}

//data class Users (
//    val users: MutableSet<String>
//)