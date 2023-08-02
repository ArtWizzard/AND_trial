package cz.matee.nemect.trial_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cz.matee.nemect.trial_01.ui.theme.Trial_01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trial_01Theme {
                Navigation()
            }
        }
    }
}