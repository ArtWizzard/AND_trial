package cz.matee.nemect.trial_02.navigation

import androidx.navigation.NamedNavArgument

object HomeDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home"
    }
}