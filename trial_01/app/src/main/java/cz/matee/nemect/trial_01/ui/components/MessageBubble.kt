package cz.matee.nemect.trial_01.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MessageBubble(
    text: String,
    modifier: Modifier = Modifier
) {
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(20.dp),
            modifier = modifier
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
}