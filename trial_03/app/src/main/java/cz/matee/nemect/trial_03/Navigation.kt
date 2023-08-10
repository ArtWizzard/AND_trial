package cz.matee.nemect.trial_03

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.matee.nemect.trial_03.presentation.home.HomeScreen
import cz.matee.nemect.trial_03.presentation.home.HomeScreenVM
import cz.matee.nemect.trial_03.presentation.library.LibraryScreen
import cz.matee.nemect.trial_03.presentation.login.LoginScreen
import cz.matee.nemect.trial_03.presentation.news.NewsScreen
import cz.matee.nemect.trial_03.presentation.premium.PremiumScreen
import cz.matee.nemect.trial_03.presentation.recent.RecentScreen
import cz.matee.nemect.trial_03.presentation.search.SearchScreen
import cz.matee.nemect.trial_03.presentation.settings.SettingsCreen
import cz.matee.nemect.trial_03.ui.components.NavigationItem


sealed class Screen( val route: String ) {
    object HomeScreen : Screen("home")
    object SearchScreen : Screen("search")
    object LibraryScreen : Screen("library")
    object PremiumScreen : Screen("premium")
    object SettingsScreen : Screen("settings")
    object NewsScreen : Screen("news")
    object RecentScreen : Screen("recent")
    object LoginScreen : Screen("login")
}

data class MainScrens (
    val screen: Screen,
    val text: String,
    val iconID: Int,
    val selected: MutableState<Boolean> = mutableStateOf(false)
)

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Navigation() {
    val navController = rememberNavController()

    val mainScreens = remember {
        listOf(
            MainScrens(Screen.HomeScreen, "Home", R.drawable.ic_home, mutableStateOf(true)),
            MainScrens(Screen.SearchScreen, "Search", R.drawable.ic_search),
            MainScrens(Screen.LibraryScreen, "Your library", R.drawable.ic_library),
            MainScrens(Screen.PremiumScreen, "Premium", R.drawable.ic_premium)
        )
    }

    Scaffold( 
        bottomBar = {

                BottomAppBar(
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .height(150.dp)
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    MaterialTheme.colorScheme.surface.copy(alpha = 0f),
                                    MaterialTheme.colorScheme.surface
                                )
                            )
                        )
                    //Brush.verticalGradient(listOf(Color.Transparent, Color.Black))
                ) {


                    mainScreens.forEach { item ->
                        NavigationItem(
                            iconID = item.iconID,
                            text = item.text,
                            selected = item.selected.value,
                            onClick = {
                                val selected = mainScreens.find { it.selected.value }
                                selected?.selected?.value = false
                                item.selected.value = true
                                navController.navigate( item.screen.route )
                            },
                            modifier = Modifier
                                .weight(1f)
                                .align(Bottom)
                        )
                    }
                }
        }) {
        NavHost(
            navController = navController, 
            startDestination = Screen.HomeScreen.route
        ) {
            composable( route = Screen.HomeScreen.route ) {
                HomeScreen( HomeScreenVM(), navController )
            }
            composable( route = Screen.SearchScreen.route ) {
                SearchScreen( navController )
            }
            composable( route = Screen.LibraryScreen.route ) {
                LibraryScreen()
            }
            composable( route = Screen.PremiumScreen.route ) {
                PremiumScreen()
            }
            composable( route = Screen.SettingsScreen.route ) {
                SettingsCreen( navController )
            }
            composable( route = Screen.LoginScreen.route ) {
                LoginScreen()
            }
            composable( route = Screen.NewsScreen.route ) {
                NewsScreen( navController )
            }
            composable( route = Screen.RecentScreen.route ) {
                RecentScreen( navController )
            }
        }
    }
}