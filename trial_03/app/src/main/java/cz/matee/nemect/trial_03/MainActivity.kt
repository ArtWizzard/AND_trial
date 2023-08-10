package cz.matee.nemect.trial_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cz.matee.nemect.trial_03.ui.theme.Trial_03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trial_03Theme {
                Navigation()
            }
        }
    }
}