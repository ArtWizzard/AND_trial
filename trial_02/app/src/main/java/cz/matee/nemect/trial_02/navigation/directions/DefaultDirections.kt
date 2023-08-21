package cz.matee.nemect.trial_02.navigation.directions

import androidx.navigation.NamedNavArgument
import cz.matee.nemect.trial_02.navigation.NavigationCommand

object DefaultDirections {
    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>() // TODO

        override val destination = ""
    }
}