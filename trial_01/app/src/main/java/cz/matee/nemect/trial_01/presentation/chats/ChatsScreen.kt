package cz.matee.nemect.trial_01.presentation.chats


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cz.matee.nemect.trial_01.R
import cz.matee.nemect.trial_01.Screens
import cz.matee.nemect.trial_01.database.User
import cz.matee.nemect.trial_01.database.UserChatPreview
import cz.matee.nemect.trial_01.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatsScreen ( navController: NavController ) {
    val convs: List<UserChatPreview> = listOf(
        UserChatPreview(User(1, "user1"), "random message"),
        UserChatPreview(User(2, "user2"), "random message 2"),
        UserChatPreview(User(3, "user3"), "random message 3")
    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier
                            .padding(0.dp)
                            .background(Color.Transparent),
                        text = stringResource(id = R.string.chats_header),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp)
                        },
             )
        },
        content = {
            LazyColumn(
                contentPadding = it,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items( convs ) { prew ->
                    Card(
                        onClick = {
                            navController.navigate(Screens.ConversationScreen.route + "/${prew.user.id}")
                        }
                    ) {
                        ConvPreview(preview = prew)
                    }
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.surface
    )
}

@Composable
fun ConvPreview ( preview: UserChatPreview ) {
    Row (
        modifier = Modifier
            .padding(0.dp)
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            Modifier
                .padding(10.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center,
        )
        {
            Image(
                modifier = Modifier
                    .padding(0.dp)
                    .background(MaterialTheme.colorScheme.primary) // why purple ??
                    .size(60.dp),
                painter = painterResource(id = preview.user.profilePicture),
                contentDescription = "Profile picture of ${preview.user.name}")
        }

        Column (
            modifier = Modifier
                .padding(start = 5.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = preview.user.name,
                color = MaterialTheme.colorScheme.surfaceTint,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)
            Text(
                text = preview.lastMessage,
                color = MaterialTheme.colorScheme.surfaceTint,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        }
    }
}