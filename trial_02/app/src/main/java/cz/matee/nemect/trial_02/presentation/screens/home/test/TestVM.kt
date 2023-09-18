package cz.matee.nemect.trial_02.presentation.screens.home.test

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_02.navigation.NavigationManager
import cz.matee.nemect.trial_02.navigation.directions.values.TestStateValue

class TestVM (
    navigationManager: NavigationManager
) : ViewModel() {

    val testState = mutableStateOf( TestStateValue.MAIN )
}