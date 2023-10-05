package cz.matee.nemect.trial_02.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingCardDivider(
    modifier: Modifier = Modifier
) {
    Divider(
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.outline,
        modifier = modifier.fillMaxSize(1f).padding( horizontal = 5.dp )
    )
}