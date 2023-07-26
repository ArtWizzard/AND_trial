package cz.matee.nemect.trial_01

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.matee.nemect.trial_01.presentation.chats.ChatsScreen
import cz.matee.nemect.trial_01.presentation.conversation.ConversationScreen

sealed class Screens( val route: String ) {
    object ChatsScreen : Screens("chats")

    object ConversationScreen : Screens("conversation")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.ChatsScreen.route ) {

        composable(route = Screens.ChatsScreen.route) {
            ChatsScreen(navController = navController)
        }

        composable(route = Screens.ConversationScreen.route) {
            ConversationScreen(navController = navController)
        }
    }
}