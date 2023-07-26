package cz.matee.nemect.trial_01.presentation.chats


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import cz.matee.nemect.trial_01.database.Conversation
import cz.matee.nemect.trial_01.database.User
import cz.matee.nemect.trial_01.database.UserChatPreview
import cz.matee.nemect.trial_01.database.UserMessage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatsScreen ( navController: NavController ) {
    val conv: Conversation = Conversation(
        listOf(User(id = 1), User(id = 2)),
        listOf(
            UserMessage(User(1), "random text 1"),
            UserMessage(User(2), "random text 2"),
            UserMessage(User(1), "random text 3")
        )
    )

    val convs: List<UserChatPreview> = listOf(
        UserChatPreview(User(1), "random message"),
        UserChatPreview(User(2), "random message 2"),
        UserChatPreview(User(3), "random message 3")
    )


    Scaffold(
        topBar = {
             TopAppBar(
                 title = { Text("Chats")},
                 navigationIcon = {
                     IconButton(onClick = { /*TODO*/ }) {
                         
                     }
                 }
             )
        },
        content = {
            LazyColumn(
                contentPadding = it
            ) {
                items( convs ) { prew ->
                    ConvPreview(preview = prew)
                }
            }
        }
    )
}

@Composable
fun ConvPreview ( preview: UserChatPreview ) {
    Row (
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = preview.user.profilePicture),
            contentDescription = "Profile picture of ${preview.user.name}")

        Column (
            horizontalAlignment = Alignment.Start
        ){
            Text(text = preview.user.name)
            Text(text = preview.lastMessage)
        }
    }
}