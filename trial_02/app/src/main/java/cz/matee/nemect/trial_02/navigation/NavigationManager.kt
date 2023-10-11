package cz.matee.nemect.trial_02.navigation

import cz.matee.nemect.trial_02.navigation.directions.DefaultDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

// must be the singleton !
class NavigationManager {

    val commands = MutableStateFlow(DefaultDirections.root)
    fun navigate (
        directions: NavigationCommand
    ) {
        commands.update { directions }
    }
}