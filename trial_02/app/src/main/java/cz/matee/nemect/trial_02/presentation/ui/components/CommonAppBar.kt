package cz.matee.nemect.trial_02.presentation.ui.components

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.presentation.screens.settings.SettingsScreen
import cz.matee.nemect.trial_02.presentation.ui.components.sideSheet.SideSheet
import cz.matee.nemect.trial_02.presentation.ui.components.sideSheet.SideSheetValue
import cz.matee.nemect.trial_02.presentation.ui.components.sideSheet.rememberSideSheetState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonAppBar(
    onMenuClick: () -> Unit,
//    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val sideSheetState = rememberSideSheetState(value = SideSheetValue.Hidden)

    TopAppBar (
        title = {},
        navigationIcon = {
            CommonIcon(
                idDrawable = R.drawable.ic_menu_24dp,
                onclick = onMenuClick,
                contentDescription = "Menu"
            )
        },
        actions = {
            CommonIcon (
                idDrawable = R.drawable.ic_settings_24dp,
                onclick = {
                    sideSheetState.expand()
                    Log.d("settings button","isVisible: ${sideSheetState.isVisible}")
                },
                contentDescription = "Settings"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = modifier
    )

    if ( sideSheetState.isVisible ) {
        Log.d("SideSheet","Recomposed")
        SideSheet(
            scope = scope,
            sideSheetState = sideSheetState,
            widthProportion = 0.7f
        ) {
            SettingsScreen()
        }
    }
}