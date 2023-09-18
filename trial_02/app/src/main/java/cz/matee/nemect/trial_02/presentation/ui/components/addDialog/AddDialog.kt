package cz.matee.nemect.trial_02.presentation.ui.components.addDialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddDialog(
    actionButton: @Composable () -> Unit,
    onClickDone: () -> Unit,
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {

    content()
}