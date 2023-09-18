package cz.matee.nemect.trial_02.presentation.ui.components.appBars

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.navigation.directions.values.MainStateValue
import cz.matee.nemect.trial_02.presentation.ui.components.icons.BottomNavigationIcon
import cz.matee.nemect.trial_02.presentation.ui.theme.AppBarRounded

@Composable
fun CommonBottomAppBar(
    homeScreenState: MutableState<MainStateValue>,
    homeAction: () -> Unit,
    testAction: () -> Unit,
    progressAction: () -> Unit,
) {
    BottomAppBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = AppBarRounded, topEnd = AppBarRounded))
            .background(Color.Transparent),
//        contentColor = MaterialTheme.colorScheme.primary,
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        BottomNavigationIcon(
            onClick = homeAction,
            isSelected = homeScreenState.value == MainStateValue.DICTIONARY,
            drawableID = R.drawable.ic_search_24px,
            contentDescription = "Dictionary",
            modifier = Modifier.weight(1f))
        BottomNavigationIcon(
            onClick = testAction,
            isSelected = homeScreenState.value == MainStateValue.TEST,
            drawableID = R.drawable.ic_test_24dp,
            contentDescription = "Test",
            modifier = Modifier.weight(1f))
        BottomNavigationIcon(
            onClick = progressAction,
            isSelected = homeScreenState.value == MainStateValue.PROGRESS,
            drawableID = R.drawable.ic_graph_24dp,
            contentDescription = "Progress",
            modifier = Modifier.weight(1f))
    }
}