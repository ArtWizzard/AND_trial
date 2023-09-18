package cz.matee.nemect.trial_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cz.matee.nemect.trial_02.core.database.DB
import cz.matee.nemect.trial_02.navigation.Navigation
import cz.matee.nemect.trial_02.presentation.ui.theme.Trial_02Theme
import cz.matee.nemect.trial_02.presentation.ui.theme.value.DarkMode
import org.koin.compose.koinInject


class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val database: DB = koinInject()

            val darkMode = remember{
                database.darkMode
            }

            Trial_02Theme ( darkTheme = isInDarkTheme(darkMode = darkMode.value)) {
                Navigation()
            }
        }
    }

    @Composable
    fun isInDarkTheme( darkMode: DarkMode): Boolean {
        return when (darkMode) {
            DarkMode.SYSTEM -> isSystemInDarkTheme()
            DarkMode.ON -> true
            DarkMode.OFF -> false
        }
    }
}