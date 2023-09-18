package cz.matee.nemect.trial_02.presentation.screens.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_02.core.database.DB
import cz.matee.nemect.trial_02.presentation.ui.theme.value.DarkMode

class SettingsVM (
    private val database: DB
): ViewModel() {

    val darkMode = mutableStateOf( database.provideDarkModeState() )

    fun toDarkMode() {
        darkMode.value = DarkMode.ON
        database.changeDarkMode( DarkMode.ON )
    }

    fun toLightMode() {
        darkMode.value = DarkMode.OFF
        database.changeDarkMode( DarkMode.OFF )
    }
}