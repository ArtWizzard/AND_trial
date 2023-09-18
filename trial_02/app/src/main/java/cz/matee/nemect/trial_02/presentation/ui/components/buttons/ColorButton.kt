package cz.matee.nemect.trial_02.presentation.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cz.matee.nemect.trial_02.presentation.ui.theme.CircleButtonSize
import cz.matee.nemect.trial_02.presentation.ui.theme.MediumIconSize

@Composable
fun ColorButton(
    onClick: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = modifier
            .size(CircleButtonSize),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        content = {}
    )
}