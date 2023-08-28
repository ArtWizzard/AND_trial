package cz.matee.nemect.trial_02.core.navigation

import androidx.compose.ui.res.stringResource
import cz.matee.nemect.trial_02.R

sealed class Screen( val route: String ) {
    object AuthenticationScreen : Screen(route = "authentication")
    object HomeScreen : Screen(route = "home")
}