package cz.matee.nemect.trial_02.presentation.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.ColorEnvelope
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.presentation.ui.components.ItemCard
import cz.matee.nemect.trial_02.presentation.ui.components.SettingCardDivider
import cz.matee.nemect.trial_02.presentation.ui.components.buttons.ColorButton
import cz.matee.nemect.trial_02.presentation.ui.components.buttons.CommonButton
import cz.matee.nemect.trial_02.presentation.ui.components.buttons.SwitchRadioButton
import cz.matee.nemect.trial_02.presentation.ui.theme.Typography
import cz.matee.nemect.trial_02.presentation.ui.theme.value.DarkMode
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsVM = koinViewModel()
) {
    val darkModeValue = remember {
        viewModel.screenState
    }

    val colorPickerIsOpen = remember {
        mutableStateOf(false)
    }

    val primary = MaterialTheme.colorScheme.primary
    val surface = MaterialTheme.colorScheme.surface
    val background = MaterialTheme.colorScheme.background
    val colorSettings = remember {
        listOf(
            ColorSettings("Primary", mutableStateOf(primary)),
            ColorSettings("Secondary", mutableStateOf(surface)),
            ColorSettings("Background", mutableStateOf(background))
        )
    }
    val colorModified = remember {
        mutableStateOf(colorSettings.first())
    }


    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.settings),
            color = MaterialTheme.colorScheme.primary,
            style = Typography.titleLarge
        )
        Divider(
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        val itemCardColor = MaterialTheme.colorScheme.surface

        LazyColumn(
            contentPadding = PaddingValues(vertical = 5.dp),
        ) {
            item {
                ItemCard(
                    onClick = {
                    },
                    containerColor = itemCardColor
                ) {
                    Column{
                        Text(
                            text = stringResource(R.string.dark_mode),
                            style = Typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                        )
                        SettingCardDivider()

                        Column( modifier = Modifier.padding(start = 20.dp)
                        ) {
                            SwitchRadioButton(
                                isSelected = darkModeValue.value == DarkMode.SYSTEM,
                                onClick = {viewModel.onDarkModeSelection(DarkMode.SYSTEM)},
                                beforeContent = { Text(text = "SYSTEM") })
                            SwitchRadioButton(
                                isSelected = darkModeValue.value == DarkMode.OFF,
                                onClick = {viewModel.onDarkModeSelection(DarkMode.OFF)},
                                beforeContent = { Text(text = "OFF") })
                            SwitchRadioButton(
                                isSelected = darkModeValue.value == DarkMode.ON,
                                onClick = {viewModel.onDarkModeSelection(DarkMode.ON)},
                                beforeContent = { Text(text = "ON") })
                        }

                    }
                }
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item {
                ItemCard(
                    containerColor = itemCardColor,
                    onClick = {}
                ) {
                    Column {
                        Text(
                            text = "Colors",
                            style = Typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .fillMaxSize()
                        )
                        SettingCardDivider()

                        colorSettings.forEach { colorS ->
                            Row(
                                modifier = Modifier.padding(start = 20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = colorS.text,
                                    style = Typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                ColorButton(
                                    onClick = {
                                        colorModified.value = colorS
                                        colorPickerIsOpen.value = true
                                    },
                                    color = colorS.color.value,
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                        }
                    }
                }
            }
            item {
                if (colorPickerIsOpen.value) {
                    ColorPicker(
                        colorSettings = colorModified,
                        isOpen = colorPickerIsOpen
                    )
                }
            }
        }
    }
}

@Composable
fun ColorPicker(
    colorSettings: MutableState<ColorSettings>,
    isOpen: MutableState<Boolean>
) {
    val colorController = rememberColorPickerController()

    Column(
        modifier = Modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HsvColorPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp),
            controller = colorController,
            initialColor = colorSettings.value.color.value,
            onColorChanged = { colorEnvelope: ColorEnvelope ->
                colorSettings.value.color.value = colorEnvelope.color
                /* TODO */
            }
        )
        BrightnessSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(35.dp),
            controller = colorController
        )
        CommonButton(
            onClick = { isOpen.value = false },
            horizontalArrangment = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(R.string.save))
        }
    }
}

data class ColorSettings(
    val text: String,
    val color: MutableState<Color>
)