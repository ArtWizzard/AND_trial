package cz.matee.nemect.trial_02.core.navigation

sealed class Screen( val route: String ) {
    object AuthenticationScreen : Screen("authentication")
    object HomeScreen : Screen("home")
}