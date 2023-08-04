package cz.matee.nemect.trial_03.presentation.settings

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
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
        
    }
}