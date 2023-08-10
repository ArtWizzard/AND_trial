package cz.matee.nemect.trial_03.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cz.matee.nemect.trial_03.R
import cz.matee.nemect.trial_03.Screen
import cz.matee.nemect.trial_03.ui.components.Alb
import cz.matee.nemect.trial_03.ui.components.IconComponent
import cz.matee.nemect.trial_03.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenVM: HomeScreenVM,
    navController: NavController
) {
    // Temporary data
    val titles = listOf("JT Music", "Pop Right Now", "TH3 DARP", "Isekai D&D", "Jednicky a nuly")
    val sections = listOf("Recently played", "Episodes for you", "Your top mixes", "JT Music", "Popular artists")

    val chips by rememberSaveable {
        mutableStateOf( homeScreenVM.chips )
    }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())     // for collapsing appbars

    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Text(
                        text = stringResource(id = R.string.Intro),
                        color = MaterialTheme.colorScheme.primary,
                        style = Typography.headlineLarge
                    )
                },
                actions = {
                    Row(
                        modifier = Modifier
                            .width(150.dp)
                    ) {
                        IconComponent(
                            painter = R.drawable.ic_notification,
                            onClick = { navController.navigate( Screen.NewsScreen.route) },
                            contentDescriptor = "Notification",
                            modifier = Modifier.weight(1f))
                        IconComponent(
                            painter = R.drawable.ic_time,
                            onClick = { navController.navigate( Screen.RecentScreen.route ) },
                            contentDescriptor = "Recently played",
                            modifier = Modifier.weight(1f))
                        IconComponent(
                            painter = R.drawable.ic_settings,
                            onClick = { navController.navigate( Screen.SettingsScreen.route )},
                            contentDescriptor = "Settings",
                            modifier = Modifier.weight(1f))
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                scrollBehavior = scrollBehavior       // for collapsing appbars
            )
        },
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ){
        Column (modifier = Modifier.padding(it)) {
            LazyRow {
                items( items = chips) {item ->
                    FilterChip(
                        selected = false,
                        onClick = {
                            homeScreenVM.changeSearchChip( item )
                        },
                        label = {
                            Text(
                                text = item.text,
                                color = if ( !item.selected.value) MaterialTheme.colorScheme.onSecondary
                                else MaterialTheme.colorScheme.onTertiary,
                                style = Typography.titleLarge)
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            containerColor = if ( !item.selected.value ) MaterialTheme.colorScheme.secondary
                            else MaterialTheme.colorScheme.tertiary
                        ),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .padding(10.dp)
                            .height(40.dp)
                    )
                }
            }

            LazyColumn (
                modifier = Modifier.padding(0.dp)
            ) {
                items( items = sections ) {item ->
                    HomeSection(text = item, titles = titles)
                }
            }
        }
    }
}


@Composable
fun HomeSection(
    text: String,
    titles: List<String>
) {
    val paddingStart = 20.dp

    // HEADER
    Text(
        text = text,
        style = Typography.headlineLarge,
        modifier = Modifier
            .padding(start = paddingStart)
    )

    // LAZYROW
    LazyRow ( modifier = Modifier
        .padding(bottom = 30.dp)
    ){
        items( items = titles) {item ->
            Alb(
                text = item,
                onClick = {},
                modifier = Modifier
                    .padding(start = paddingStart, top = 5.dp, bottom = 5.dp))
        }
    }
}
