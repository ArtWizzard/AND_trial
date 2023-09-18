package cz.matee.nemect.trial_02.presentation.ui.components.icons

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun CommonIcon(
    onclick: () -> Unit,
    idDrawable: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onclick,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = idDrawable),
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onPrimary)
    }
}