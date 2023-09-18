package cz.matee.nemect.trial_02.navigation.directions

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import cz.matee.nemect.trial_02.navigation.NavigationCommand

object DictionaryDirections {

    val languageID = "lang"
    val route = "dictionary/{$languageID}"
    val dictionaryArguments = listOf(
        navArgument(languageID) {type = NavType.StringType}
    )

    fun dictionary(
        languageCode: String? = null
    ) = object : NavigationCommand {

        override val arguments: List<NamedNavArgument>
            get() = dictionaryArguments

        override val destination: String
            get() = "dictionary/$languageCode"
    }
}