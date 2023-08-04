package cz.matee.nemect.trial_03.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cz.matee.nemect.trial_03.ui.theme.Typography

@Composable
fun NavigationItem(
    iconID: Int,
    text: String,
    onClick: () -> Unit,
    selected: Boolean = false,
    modifier: Modifier = Modifier
) {
    val itemColor = if ( selected ) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline


    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Column {
            Icon(
                painter = painterResource(id = iconID),
                contentDescription = text,
                tint = itemColor)
            Text(
                text = text,
                style = Typography.labelSmall,
                color = itemColor)
        }
    }

}