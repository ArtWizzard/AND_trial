package cz.matee.nemect.trial_02.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.matee.nemect.trial_02.navigation.directions.*
import cz.matee.nemect.trial_02.navigation.directions.values.MainStateValue
import cz.matee.nemect.trial_02.navigation.directions.values.TestStateValue
import cz.matee.nemect.trial_02.presentation.screens.home.HomeScreen
import cz.matee.nemect.trial_02.presentation.screens.home.dictionary.DictionaryScreen
import cz.matee.nemect.trial_02.presentation.screens.home.progress.ProgressScreen
import cz.matee.nemect.trial_02.presentation.screens.home.test.TestVM
import cz.matee.nemect.trial_02.presentation.screens.home.test.main.TestMainScreen
import cz.matee.nemect.trial_02.presentation.screens.home.test.result.TestResultScreen
import cz.matee.nemect.trial_02.presentation.screens.home.test.run.TestRunScreen
import cz.matee.nemect.trial_02.presentation.screens.language.LanguageScreen
import cz.matee.nemect.trial_02.presentation.screens.wordPreview.WordPreview
import org.koin.compose.koinInject

@Composable
fun Navigation(
    navigationManager: NavigationManager = koinInject()
) {

    val navController = rememberNavController()

//  common shared testVM for testScreen
    val testVM: TestVM = koinInject()

    // Navigation scaffold
    NavHost(
        navController = navController,
        startDestination = LanguageDirections.root.destination
    ) {

        // LANGUAGE
        composable(LanguageDirections.root.destination) {
            LanguageScreen()
        }

        // DICTIONARY
        composable(DictionaryDirections.route) { backStackEntry ->
            HomeScreen(
                languageCode = backStackEntry.arguments?.getString(DictionaryDirections.languageID),
                homeScreenState = MainStateValue.DICTIONARY
            ) {
                DictionaryScreen()
            }
        }

        // TEST
        composable(TestDirections.route) { backStackEntry ->
            HomeScreen(
                languageCode = backStackEntry.arguments?.getString(DictionaryDirections.languageID),
                homeScreenState = MainStateValue.TEST
            ) {
                when ( backStackEntry.arguments?.getString(TestDirections.stateID)) {
                    TestStateValue.MAIN.name -> TestMainScreen(testVM)
                    TestStateValue.TEST.name -> TestRunScreen(testVM)
                    TestStateValue.RESULT.name -> TestResultScreen(testVM)
                }
            }
        }

        // PREVIEW
        composable(PreviewDirections.route) { backStackEntry ->
            HomeScreen(
                languageCode = backStackEntry.arguments?.getString(DictionaryDirections.languageID),
                homeScreenState = MainStateValue.PREVIEW
            ) {
                WordPreview()
            }
        }

        // PROGRESS
        composable(ProgressDirections.route) { backStackEntry ->
            HomeScreen(
                languageCode = backStackEntry.arguments?.getString(DictionaryDirections.languageID),
                homeScreenState = MainStateValue.PROGRESS
            ) {
                ProgressScreen()
            }
        }
    }

    navigationManager.commands.collectAsState().value.also { command ->

        // command is set to null when first created/recomposed
        if (command.destination.isNotEmpty())
            navController.navigate(command.destination)
    }
}