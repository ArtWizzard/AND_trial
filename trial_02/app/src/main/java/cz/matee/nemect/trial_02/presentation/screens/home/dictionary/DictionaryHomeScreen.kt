package cz.matee.nemect.trial_02.presentation.screens.home.dictionary

import android.graphics.Paint.Style
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.presentation.ui.components.CommonButton
import cz.matee.nemect.trial_02.presentation.ui.components.ItemCard
import cz.matee.nemect.trial_02.presentation.ui.theme.Typography
import org.koin.androidx.compose.koinViewModel

@Composable
fun DictionaryHomeScreen(
    viewModel: DictionaryHomeScreenVM = koinViewModel(),
) {
    val emptySearch = remember {
        mutableStateOf(viewModel.nothingFound)
    }

    val words = remember {
        viewModel.getWords()
    }


    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            CommonButton(
                onClick = { Log.d("CommonButton", "Cliked")},
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "EN",
                    style = Typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary)
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_forward_48px), 
                    contentDescription = stringResource(R.string.direction_of_translation),
                    modifier = Modifier
                        .size(30.dp)
                )
                Text(
                    text = "CZ",
                    style = Typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary)
            }
        }

        if (emptySearch.value) {
            item {
                val addButtonRounded = 30.dp

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(R.string.nothing_to_find),
                        style = Typography.headlineMedium.copy(fontWeight = FontWeight.Normal),
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = TextAlign.Center)
                    CommonButton(
                        onClick = { Log.d("CommonButton", "Cliked")},
                        verticalAlignment = Alignment.CenterVertically,
                        contentPadding = PaddingValues(0.dp),
                        shape = RoundedCornerShape(addButtonRounded)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add_outlined_24dp),
                            contentDescription = stringResource(R.string.add),
                            modifier = Modifier
                                .size(addButtonRounded * 2)
                        )
                        Text(
                            text = stringResource(id = R.string.add),
                            style = Typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(horizontal = 10.dp))
                    }
                }
            }
        } else {
            items(items = words) {
                ItemCard(onClick = { /*TODO*/ }) {
                    Text(text = it.value)
                }
            }
        }

    }
}