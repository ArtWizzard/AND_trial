package cz.matee.nemect.trial_02.presentation.ui.components.appBars

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.presentation.screens.settings.SettingsScreen
import cz.matee.nemect.trial_02.presentation.ui.components.icons.CommonIcon
import cz.matee.nemect.trial_02.presentation.ui.components.sideSheet.SideSheet
import cz.matee.nemect.trial_02.presentation.ui.components.sideSheet.SideSheetValue
import cz.matee.nemect.trial_02.presentation.ui.components.sideSheet.rememberSideSheetState
import cz.matee.nemect.trial_02.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonAppBar(
    onMenuClick: () -> Unit,
//    onSettingsClick: () -> Unit,
    header: String,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val sideSheetState = rememberSideSheetState(value = SideSheetValue.Hidden)

    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = header,
                    style = Typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        },
        navigationIcon = {
            CommonIcon(
                idDrawable = R.drawable.ic_menu_24dp,
                onclick = onMenuClick,
                contentDescription = stringResource(R.string.menu)
            )
        },
        actions = {
            CommonIcon(
                idDrawable = R.drawable.ic_settings_24dp,
                onclick = {
                    sideSheetState.expand()
                },
                contentDescription = stringResource(id = R.string.settings)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = modifier
    )

    if (sideSheetState.isVisible) {
        SideSheet(
            scope = scope,
            sideSheetState = sideSheetState,
            widthProportion = 0.7f
        ) {
            SettingsScreen()
        }
    }
}