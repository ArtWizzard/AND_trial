package cz.matee.nemect.trial_03

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.matee.nemect.trial_03.presentation.home.HomeScreen
import cz.matee.nemect.trial_03.ui.components.NavigationItem


sealed class Screen( val route: String ) {
    object HomeScreen : Screen("home")
    object SearchScreen : Screen("search")
    object LibraryScreen : Screen("library")
    object PremiumScreen : Screen("premium")
    object SettingsScreen : Screen("settings")
    object NewsScreen : Screen("news")
    object RecentScreen : Screen("recent")
}

data class MainScrens (
    val screen: Screen,
    val text: String,
    val iconID: Int,
    var selected: Boolean = false
)

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Navigation() {
    val navController = rememberNavController()

    Scaffold( 
        bottomBar = {

                BottomAppBar(
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .height(150.dp)
                        .background(
                            Brush.verticalGradient(listOf(
                                MaterialTheme.colorScheme.surface.copy(alpha = 0f),
                                MaterialTheme.colorScheme.surface
                            ))
                        )
                    //Brush.verticalGradient(listOf(Color.Transparent, Color.Black))
                ) {
                    val mainScreens = listOf(
                        MainScrens(Screen.HomeScreen, "Home", R.drawable.ic_home, true),
                        MainScrens(Screen.SearchScreen, "Search", R.drawable.ic_search),
                        MainScrens(Screen.LibraryScreen, "Your library", R.drawable.ic_library),
                        MainScrens(Screen.PremiumScreen, "Premium", R.drawable.ic_premium)
                    )

                    mainScreens.forEach { item ->
                        NavigationItem(
                            iconID = item.iconID,
                            text = item.text,
                            selected = item.selected,
                            onClick = { /*TODO*/ },
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
                HomeScreen()
            }
        }
    }
}