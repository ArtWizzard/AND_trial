package cz.matee.nemect.trial_02.navigation

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import cz.matee.nemect.trial_02.navigation.directions.NavigationDirections.Default

// must be the singleton !
class NavigationManager {

    var commands = MutableStateFlow(Default)

    fun navigate (
        directions: NavigationCommand
    ) {
        Log.d("NavManager","Navigated: ${directions.destination}")
        commands.value = directions
    }
}