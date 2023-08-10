package cz.matee.nemect.trial_03.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconComponent(
    painter: Int,
    onClick: () -> Unit,
    contentDescriptor: String?,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.primary,
    containerColor: Color = Color.Transparent
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .size(30.dp)
            .background(containerColor),
    ) {
        Icon(
            painter = painterResource(id = painter),
            contentDescription = contentDescriptor,
            tint = contentColor,
            modifier = Modifier
                .size(40.dp))
    }
}