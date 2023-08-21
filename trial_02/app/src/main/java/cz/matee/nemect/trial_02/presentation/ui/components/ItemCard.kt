package cz.matee.nemect.trial_02.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cz.matee.nemect.trial_02.presentation.ui.theme.ItemCardRounded

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.background,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(ItemCardRounded))
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        onClick = onClick
    ) {
        content()
    }
}