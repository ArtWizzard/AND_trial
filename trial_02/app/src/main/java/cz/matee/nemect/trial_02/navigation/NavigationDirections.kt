package cz.matee.nemect.trial_02.navigation

import androidx.navigation.NamedNavArgument

// implementation of navigation directions - sample
object NavigationDirections {

    val Authentication = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>() // TODO

        override val destination = "authentication"
    }

    val Home = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>() // TODO

        override val destination = "home"
    }
}