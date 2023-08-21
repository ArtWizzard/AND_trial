package cz.matee.nemect.trial_02.navigation.directions

import androidx.navigation.NamedNavArgument
import cz.matee.nemect.trial_02.navigation.NavigationCommand

// implementation of navigation directions - sample
object NavigationDirections {

//    val Language = object : NavigationCommand {
//
//        override val arguments = emptyList<NamedNavArgument>() // TODO
//
//        override val destination = "language"
//    }

//    val Home = object : NavigationCommand {
//
//        override val arguments = emptyList<NamedNavArgument>() // TODO
//
//        override val destination = "home"
//    }
    val Home = HomeDirections.root
    val Language = LanguageDirections.root
    val Default = DefaultDirections.root

}