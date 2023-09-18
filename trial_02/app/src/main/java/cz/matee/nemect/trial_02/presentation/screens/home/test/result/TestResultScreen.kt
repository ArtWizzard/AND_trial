package cz.matee.nemect.trial_02.presentation.screens.home.test.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cz.matee.nemect.trial_02.presentation.screens.home.test.TestVM
import cz.matee.nemect.trial_02.presentation.ui.theme.AppBarRounded

@Composable
fun TestResultScreen(
    viewModel: TestVM
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(topStart = AppBarRounded, topEnd = AppBarRounded),
            modifier = Modifier
                .fillMaxSize()
        ) {
            // content TODO
        }
    }
}