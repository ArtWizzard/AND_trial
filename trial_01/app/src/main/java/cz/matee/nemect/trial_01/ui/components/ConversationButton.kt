package cz.matee.nemect.trial_01.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.core.graphics.drawable.IconCompat.IconType

@Composable
fun ConversationButton (
    icon: ,
    contentDescription: String? = null
) {
    androidx.compose.material3.Icon(
        imageVector = icon,
        contentDescription = contentDescription)
}