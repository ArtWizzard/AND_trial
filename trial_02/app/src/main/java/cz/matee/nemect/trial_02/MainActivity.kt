package cz.matee.nemect.trial_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cz.matee.nemect.trial_02.navigation.Navigation
import cz.matee.nemect.trial_02.presentation.ui.theme.Trial_02Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trial_02Theme {
                Navigation()
            }
        }
    }
}