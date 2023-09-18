package cz.matee.nemect.trial_02.presentation.ui.components.icons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cz.matee.nemect.trial_02.presentation.ui.theme.NavigationButtonRounded

@Composable
fun BottomNavigationIcon(
    onClick: () -> Unit,
    drawableID: Int,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    contentDescription: String?
) {
    val color = if ( isSelected ) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Surface(
            color = color,
            shape = RoundedCornerShape(NavigationButtonRounded),
            modifier = Modifier
                .fillMaxSize(0.8f)
                .clip(RoundedCornerShape(NavigationButtonRounded))
                .clickable { onClick() }
        ) {
            Icon(
                painter = painterResource(id = drawableID),
                contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(5.dp)
            )
        }

    }
}