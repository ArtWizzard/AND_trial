package cz.matee.nemect.trial_02.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.matee.nemect.trial_02.presentation.screens.authentication.AuthenticationScreen
import cz.matee.nemect.trial_02.presentation.screens.home.HomeScreen
import org.koin.compose.koinInject

@Composable
fun Navigation(
    navigationManager: NavigationManager = koinInject()
) {

    val navController = rememberNavController()
    navigationManager.commands.collectAsState().value.also { command ->
        if ( command.destination.isNotEmpty() ) {
            navController.navigate(command.destination)
        }
    }


    NavHost(
        navController = navController,
        startDestination =  NavigationDirections.Authentication.destination
    ) {
        composable( NavigationDirections.Authentication.destination ) {
            AuthenticationScreen()
        }

        composable( NavigationDirections.Home.destination ) {
            HomeScreen()
        }
    }

}