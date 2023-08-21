package cz.matee.nemect.trial_02.presentation.screens.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.navArgument
import cz.matee.nemect.trial_02.presentation.ui.components.CommonAppBar
import cz.matee.nemect.trial_02.presentation.ui.theme.AppBarRounded
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeVM = koinViewModel()
) {
    // back button handle - go to language
    BackHandler(onBack = {
        viewModel.navigateToLanguage()
    })

    Scaffold(
        topBar = {
            CommonAppBar(
                onMenuClick = { viewModel.navigateToLanguage() },
                modifier = Modifier
                    .padding(bottom = AppBarRounded)

            )
        },
        containerColor = MaterialTheme.colorScheme.primary
    ) {

        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(topStart = AppBarRounded, topEnd = AppBarRounded),
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}