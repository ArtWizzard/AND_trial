package cz.matee.nemect.trial_02.presentation.screens.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.matee.nemect.trial_02.core.database.datastore.profile.ProfileDataSource
import cz.matee.nemect.trial_02.core.database.datastore.profile.ProfileScreenState
import cz.matee.nemect.trial_02.presentation.ui.theme.value.DarkMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsVM (
    private val profileDataSource: ProfileDataSource
): ViewModel() {

    private val _screenStateStream = MutableStateFlow(ProfileScreenState())
    val screenStateStream get() = _screenStateStream.asStateFlow()
    val screenState = mutableStateOf(screenStateStream.value.selectedDarkMode)

    init {
        viewModelScope.launch {
            _screenStateStream.update { state ->
                state.copy(
                    selectedDarkMode = profileDataSource.getDarkModeStream().first(),
                )
            }
        }
    }

    fun onDarkModeSelection(darkMode: DarkMode) {
        _screenStateStream.update { state -> state.copy(selectedDarkMode = darkMode) }

        screenState.value = darkMode

        viewModelScope.launch {
            profileDataSource.setDarkMode(screenStateStream.value.selectedDarkMode)
        }
    }
}