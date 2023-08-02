package cz.matee.nemect.trial_01.presentation.conversation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cz.matee.nemect.trial_01.Screens
import cz.matee.nemect.trial_01.database.Conversation
import cz.matee.nemect.trial_01.database.User
import cz.matee.nemect.trial_01.database.UserMessage
import cz.matee.nemect.trial_01.ui.components.ConversationButton
import cz.matee.nemect.trial_01.ui.components.MessageBubble
import cz.matee.nemect.trial_01.R.drawable

data class ButtonDescription(
    val icon: Int,
    val contentDescription: String,
    val onClick: (() -> Unit)? = null,
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationScreen ( navController: NavController, id: Int?) {
    val conv: Conversation = Conversation(
        listOf(User(id = 1), User(id = 2)),
        listOf(
            UserMessage(User(1), "random text 1"),
            UserMessage(User(2), "random text 2"),
            UserMessage(User(1), "random text 3 random text 3 random text 3 random text 3 random text 3 random text 3")
        )
    )
    

    // get from VM
    val name = "Username"
//    val user_id = 1

    val buttons: Map<String,ButtonDescription> = mapOf(
        "Menu" to ButtonDescription(
            icon = drawable.apps_icon_24dp,
            contentDescription = "Apps"
        ),
        "Galery" to ButtonDescription(
            icon = drawable.image_icon_24dp,
            contentDescription = "Camera"
        ),
        "Camera" to ButtonDescription(
            icon = drawable.camera_icon_24dp,
            contentDescription = "Images"
        ),
        "Microphone" to ButtonDescription(
            icon = drawable.mic_icon_24dp,
            contentDescription = "Voice recording"
        )
    )


    Scaffold (
        topBar = {
            Surface(
                shadowElevation = 5.dp
            ) {
                TopAppBar (
                    title = {
                        Text(
                            text = name,
                            color = MaterialTheme.colorScheme.surfaceTint
                        )
                    },
                    navigationIcon = {
                        ConversationButton(
                            icon = drawable.west_icon_24dp,
//                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(30.dp),
                            onClick = {
                                navController.navigate(Screens.ChatsScreen.route)
                            })
                    }
                )
            }
        },
        bottomBar = {
            BottomAppBar (
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .height(50.dp)
            ) {
                for ( description in buttons) {
                    ConversationButton(
                        icon = description.value.icon,
                        onClick = {description.value.onClick},
                        contentDescription = description.value.contentDescription,
                        modifier = Modifier
                            .padding(0.dp)
                    )
                }
            }
        }
    ) {
        LazyColumn (
            Modifier
                .padding(it)
                ){
            items( conv.messages ) {item ->
                MessageBubble(
                    text = item.text,
                    modifier = Modifier
                        .padding(
                            horizontal = 20.dp,
                            vertical = 5.dp
                        )
                        .widthIn(0.dp, 200.dp) // hard-coded
                )
            }
        }
    }
}