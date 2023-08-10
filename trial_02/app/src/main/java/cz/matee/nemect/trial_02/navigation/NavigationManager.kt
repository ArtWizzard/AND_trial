package cz.matee.nemect.trial_02.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import cz.matee.nemect.trial_02.navigation.AuthenticationDirections.Default

// must be the singleton !
class NavigationManager {

    var commands = MutableStateFlow(Default)

    fun navigate (
        directions: NavigationCommand
    ) {
        commands.value = directions
    }
}