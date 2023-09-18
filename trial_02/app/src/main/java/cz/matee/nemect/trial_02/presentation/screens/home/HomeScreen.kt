package cz.matee.nemect.trial_02.presentation.screens.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.navigation.directions.values.MainStateValue
import cz.matee.nemect.trial_02.presentation.ui.components.appBars.CommonAppBar
import cz.matee.nemect.trial_02.presentation.ui.components.appBars.CommonBottomAppBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    homeScreenState: MainStateValue,
    languageCode: String? = null,
    viewModel: HomeVM = koinViewModel(),
    contentScreen: @Composable () -> Unit
) {
    viewModel.homeState.value = homeScreenState

    val screenState = remember {
        viewModel.homeState
    }

    // back button handle - go to language
    BackHandler(onBack = {
        viewModel.navigateToLanguage()
    })

    // Draw over each
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        // Color background handling
        Column(modifier = Modifier.fillMaxSize()) {
            Surface( modifier = Modifier
                .weight(1f)
                .fillMaxSize(), color = MaterialTheme.colorScheme.primary ) {}
            Surface( modifier = Modifier
                .weight(1f)
                .fillMaxSize(), color = MaterialTheme.colorScheme.surface ) {}
        }

        // Components
        Scaffold(
            topBar = {
                CommonAppBar(
                    onMenuClick = { viewModel.navigateToLanguage() },
                    header = languageCode ?: stringResource(R.string.unknown)
                )
            },
            bottomBar = {
                CommonBottomAppBar(
                    screenState,
                    {viewModel.navigateToDictionary()},
                    {viewModel.navigateToTest()},
                    {viewModel.navigateToProgress()}
                )
            },
            containerColor = Color.Transparent
        ) {
            Surface (modifier = Modifier.padding(it), color = Color.Transparent) {
                contentScreen()
            }
        }
    }
}