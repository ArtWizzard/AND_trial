package cz.matee.nemect.trial_03.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cz.matee.nemect.trial_03.R
import cz.matee.nemect.trial_03.Screen
import cz.matee.nemect.trial_03.ui.components.IconComponent
import cz.matee.nemect.trial_03.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsCreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.SettingsScreen),
                        style = Typography.headlineLarge,
                        color = MaterialTheme.colorScheme.primary)
                },
                navigationIcon = {
                    IconComponent(
                        painter = R.drawable.ic_arrow_back,
                        onClick = { navController.navigate( Screen.HomeScreen.route )},
                        contentDescriptor = "Back")
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.Blue),
            color = Color.Transparent
        ) {
            Text(
                modifier = Modifier
//                    .align(Alignment.Center)
                    .rotate(90f)
                    .background(Color.Red),
                text = "ČTYŘI",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold)

        }
    }
}