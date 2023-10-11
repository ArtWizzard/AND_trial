package cz.matee.nemect.trial_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cz.matee.nemect.trial_02.core.data.datastore.profile.ProfileDataSource
import cz.matee.nemect.trial_02.navigation.Navigation
import cz.matee.nemect.trial_02.presentation.ui.theme.Trial_02Theme
import cz.matee.nemect.trial_02.presentation.ui.theme.value.DarkMode
import org.koin.compose.koinInject


class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val profileDataSource: ProfileDataSource = koinInject()
            val darkMode by profileDataSource.getDarkModeStream().collectAsState(initial = null)
            darkMode?.let {
                Trial_02Theme(isInDarkTheme(it)) {
                    Navigation()
                }
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