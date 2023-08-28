package cz.matee.nemect.trial_02.presentation.screens.language

import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_02.core.database.DB
import cz.matee.nemect.trial_02.navigation.NavigationManager
import cz.matee.nemect.trial_02.navigation.directions.NavigationDirections
import kotlinx.coroutines.coroutineScope

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

    fun navigateToHome( language: String ) {
        navigationManager.navigate(NavigationDirections.Home)
    }

    fun addNewUser() {
        database.addLanguage("French","FR")
    }
}

//data class Users (
//    val users: MutableSet<String>
//)