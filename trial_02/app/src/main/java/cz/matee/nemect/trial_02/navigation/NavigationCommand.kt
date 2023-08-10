package cz.matee.nemect.trial_02.navigation

import androidx.navigation.NamedNavArgument

// Contains navigation event
interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}