package cz.matee.nemect.trial_02.navigation.directions

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import cz.matee.nemect.trial_02.navigation.NavigationCommand

object PreviewDirections {

    val languageID = "lang"
    val wordID = "word"

    val route = "preview/{$languageID}/{$wordID}"
    val dictionaryArguments = listOf(
        navArgument(languageID) {type = NavType.StringType},
        navArgument(languageID) {type = NavType.StringType}
    )

    fun preview(
        languageCode: String? = null,
        word: String
    ) = object : NavigationCommand {

        override val arguments: List<NamedNavArgument>
            get() = dictionaryArguments

        override val destination: String
            get() = "preview/$languageCode/$word"
    }
}