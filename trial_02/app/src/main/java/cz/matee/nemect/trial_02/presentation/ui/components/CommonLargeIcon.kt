package cz.matee.nemect.trial_02.presentation.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CommonLargeIcon(
    onClick: () -> Unit,
    drawableID: Int,
    contentDescriptor: String?,
    color: Color = MaterialTheme.colorScheme.primary
) {
    TextButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = drawableID),
            contentDescription = contentDescriptor,
            tint = color,
            modifier = Modifier
                .size(70.dp)
            )
    }
}