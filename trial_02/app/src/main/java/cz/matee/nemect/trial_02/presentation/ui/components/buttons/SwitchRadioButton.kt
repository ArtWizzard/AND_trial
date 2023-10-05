package cz.matee.nemect.trial_02.presentation.ui.components.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SwitchRadioButton(
    isSelected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    beforeContent: (@Composable () -> Unit)? = null,
    afterContent: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (beforeContent != null) {
            beforeContent()
            Spacer(modifier = Modifier.weight(1f))
        }
        RadioButton(
            selected = isSelected,
            onClick = onClick)
        if (afterContent != null) {
            Spacer(modifier = Modifier.weight(1f))
            afterContent()
        }
    }

}