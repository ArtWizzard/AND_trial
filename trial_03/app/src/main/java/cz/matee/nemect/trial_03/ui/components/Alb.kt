package cz.matee.nemect.trial_03.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import cz.matee.nemect.trial_03.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Alb(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card (
        onClick = onClick,
        colors = CardDefaults.cardColors( containerColor = MaterialTheme.colorScheme.surface),
        shape = RectangleShape,
        modifier = modifier
            .size(160.dp)
    ){
        Column {
//            Image(
//                painter = painterResource(id = R.mipmap.ic_launcher),
//                contentDescription = "Hearth logo",
//                modifier = Modifier
//                    .size(80.dp))

            AsyncImage(
                model = "https://wallsofneon.com/cdn/shop/products/heartsymbol_742fc274-8da7-4399-a795-108ea9b28676_600x.jpg?v=1617942005",
                contentDescription = "Hearth icon",
                modifier = Modifier
                    .size(140.dp)
            )


            Text(
                text = text,
                style = Typography.titleLarge,
                color = Color.White,//MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .align(CenterHorizontally)
            )
        }
    }
}