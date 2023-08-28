package cz.matee.nemect.trial_02.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import cz.matee.nemect.trial_02.presentation.ui.theme.ButtonRounded

@Composable
fun CommonButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    horizontalArrangment: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    contentPadding: PaddingValues = PaddingValues(horizontal = ButtonRounded),
    shape: Shape = RoundedCornerShape(ButtonRounded),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .wrapContentSize()
            .padding(ButtonRounded),
        color = containerColor,
        contentColor = contentColor,
        shape = shape
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .wrapContentSize()
                .sizeIn(minWidth = ButtonRounded * 2, minHeight = ButtonRounded * 2)
                .padding(contentPadding),
            horizontalArrangement = horizontalArrangment,
            verticalAlignment = verticalAlignment
        ) {
            content()
        }
    }
}
