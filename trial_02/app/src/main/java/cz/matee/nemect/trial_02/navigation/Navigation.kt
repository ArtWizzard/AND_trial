package cz.matee.nemect.trial_02.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.matee.nemect.trial_02.navigation.directions.NavigationDirections
import cz.matee.nemect.trial_02.presentation.screens.language.LanguageScreen
import cz.matee.nemect.trial_02.presentation.screens.home.HomeScreen
import org.koin.compose.koinInject

@Composable
fun Navigation(
    navigationManager: NavigationManager = koinInject()
) {

    val navController = rememberNavController()
    navigationManager.commands.collectAsState().value.also { command ->

//        Log.d("nav","change ${command.destination}")
        if ( command.destination.isNotEmpty() ) {
//            Log.d("Navigation","arg: ${command.arguments}\n dir: ${command.destination}")

            try {
                Log.d("navController","current: ${navController.currentDestination}")
                Log.d("navController","backStackEntry: ${navController.currentBackStackEntry?.destination}")
                Log.d("navController","accessing: ${command.destination}")
                Log.d("nav", command.destination)
                navController.navigate(command.destination)

            } catch (ex: Exception) {
                Log.d("exception nav","caught exception: ")
                Log.d("exception nav","cause = ${ex.cause}")
                Log.d("exception nav","message = ${ex.message}")
                Log.d("exception nav","stackTrace = ${ex.stackTrace}")
                Log.d("exception nav","suppressed = ${ex.suppressed}")
                Log.d("exception nav","localize message = ${ex.localizedMessage}")
            }

        } else {
            Log.d("Navigation","arg: ${command.arguments}\n dir: ${command.destination} - is empty")
        }
    }


    NavHost(
        navController = navController,
        startDestination =  NavigationDirections.Language.destination
    ) {
        composable( NavigationDirections.Language.destination ) {
            LanguageScreen()
        }

        composable( NavigationDirections.Home.destination ) {
            HomeScreen()
        }
    }

}