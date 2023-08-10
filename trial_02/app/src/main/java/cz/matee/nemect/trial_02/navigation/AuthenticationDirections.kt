package cz.matee.nemect.trial_02.navigation

import androidx.navigation.NamedNavArgument

object AuthenticationDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "authentication"
    }

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""
    }
}