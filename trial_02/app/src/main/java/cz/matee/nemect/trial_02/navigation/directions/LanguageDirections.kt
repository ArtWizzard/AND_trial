package cz.matee.nemect.trial_02.navigation.directions

import androidx.navigation.NamedNavArgument
import cz.matee.nemect.trial_02.navigation.NavigationCommand

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