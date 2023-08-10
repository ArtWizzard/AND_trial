package cz.matee.nemect.trial_03.presentation.news

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import cz.matee.nemect.trial_03.R
import cz.matee.nemect.trial_03.Screen
import cz.matee.nemect.trial_03.ui.components.IconComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
//                    Text(
//                        text = stringResource(id = R.string.SettingsScreen),
//                        style = Typography.headlineLarge,
//                        color = MaterialTheme.colorScheme.primary)
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

    }
}