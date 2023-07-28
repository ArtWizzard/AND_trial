package cz.matee.nemect.trial_01.presentation.conversation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.resolveDefaults
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cz.matee.nemect.trial_01.Screens
import cz.matee.nemect.trial_01.database.Conversation
import cz.matee.nemect.trial_01.database.User
import cz.matee.nemect.trial_01.database.UserMessage
import cz.matee.nemect.trial_01.ui.theme.White1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationScreen ( navController: NavController, id: Int?) {
    val conv: Conversation = Conversation(
        listOf(User(id = 1), User(id = 2)),
        listOf(
            UserMessage(User(1), "random text 1"),
            UserMessage(User(2), "random text 2"),
            UserMessage(User(1), "random text 3")
        )
    )

//    Log.d("Color white","${Color.White}")
//    Log.d("Color","${MaterialTheme.colorScheme.onPrimary}")

    Scaffold (
        topBar = {
            TopAppBar (
                title = { Text(text = "User name")},
                navigationIcon = {
                    Button(
                        onClick = { navController.navigate(Screens.ChatsScreen.route)},
                        colors = ButtonDefaults.buttonColors(
//                            contentColor = Color.Blue,
                            containerColor = Color.Transparent
                        )
//                        modifier = Modifier
//                            .background(Color.Green)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back to chats",
                            tint = White1,//MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .size(30.dp)
//                                .background(Color.Red)
                        )
                    }
                }
            )
        },
        bottomBar = {

        }
    ) {

    }

}