package cz.matee.nemect.trial_03.presentation.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cz.matee.nemect.trial_03.R
import cz.matee.nemect.trial_03.ui.components.IconComponent
import cz.matee.nemect.trial_03.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())     // for collapsing appbars


    Scaffold(
        topBar = {
            TopAppBar (
                title = {
                    Text(
                        text = stringResource(id = R.string.SearchScreen),
                        color = MaterialTheme.colorScheme.primary,
                        style = Typography.headlineLarge
                    )
                },
                actions = {
                        IconComponent(
                            painter = R.drawable.ic_camera,
                            onClick = { /*TODO*/ },
                            contentDescriptor = "Camera",
                        )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                scrollBehavior = scrollBehavior       // for collapsing appbars
            )
        }
    ) {
        LazyColumn {

        }
    }
}