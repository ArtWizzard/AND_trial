package cz.matee.nemect.trial_02.presentation.ui.components.sliders

import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ProgressSlider(
    value: Float,
    onValueChange: (it: Float) -> Unit,
    color: Color,
    modifier: Modifier = Modifier
) {
    Slider(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier,
        colors = SliderDefaults.colors(
            thumbColor = color,
            activeTrackColor = color
        )
    )
}