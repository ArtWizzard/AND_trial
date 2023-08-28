package cz.matee.nemect.trial_02.presentation.screens.settings

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.presentation.ui.components.ColorButton
import cz.matee.nemect.trial_02.presentation.ui.components.ItemCard
import cz.matee.nemect.trial_02.presentation.ui.theme.Typography

@Composable
fun SettingsScreen() {
    val darkMode = rememberSaveable{
        mutableStateOf(false)
    }

    Column (
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
        LazyColumn {
            item {
                ItemCard (
                    onClick = {
                        Log.d("ItemCard","clicked")
                    },
                    containerColor = itemCardColor
                ) {
                    Text(
                        text = stringResource(R.string.dark_mode),
                        style = Typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                    )
                    Switch(
                        checked = darkMode.value,
                        onCheckedChange = {
                            darkMode.value = !darkMode.value },
                        modifier = Modifier.align(End)
                    )
                }
            }
            item {
                ItemCard(
                    onClick = { Log.d("ItemCard","clicked") },
                    containerColor = itemCardColor
                ) {
                    Row {
                        ColorButton(onClick = { Log.d("ColorButton","clicked")  }, color = MaterialTheme.colorScheme.primary)
                        ColorButton(onClick = { Log.d("ColorButton","clicked")  }, color = MaterialTheme.colorScheme.surface)
                        ColorButton(onClick = { Log.d("ColorButton","clicked")  }, color = MaterialTheme.colorScheme.background)
                    }
                }
            }
        }

    }

}