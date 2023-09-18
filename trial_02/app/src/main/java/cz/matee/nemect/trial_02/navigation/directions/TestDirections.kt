package cz.matee.nemect.trial_02.navigation.directions

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import cz.matee.nemect.trial_02.navigation.NavigationCommand
import cz.matee.nemect.trial_02.navigation.directions.values.TestStateValue

object TestDirections {

    val languageID = "lang"
    val stateID = "state"

    val route = "test/{$languageID}/{$stateID}"
    val dictionaryArguments = listOf(
        navArgument(languageID) {type = NavType.StringType},
        navArgument(stateID) {type = NavType.StringType}
    )

    fun test(
        languageCode: String? = null,
        testState: TestStateValue
    ) = object : NavigationCommand {

        override val arguments: List<NamedNavArgument>
            get() = dictionaryArguments

        override val destination: String
            get() = "test/$languageCode/${testState.name}"
    }
}