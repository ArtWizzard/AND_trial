package cz.matee.nemect.trial_02.presentation.screens.home.dictionary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.presentation.ui.components.ItemCard
import cz.matee.nemect.trial_02.presentation.ui.components.buttons.CommonButton
import cz.matee.nemect.trial_02.presentation.ui.theme.AppBarRounded
import cz.matee.nemect.trial_02.presentation.ui.theme.DictionaryWidthScaleBody
import cz.matee.nemect.trial_02.presentation.ui.theme.Typography
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryScreen(
    viewModel: DictionaryScreenVM = koinViewModel(),
) {

    val searchQuery = remember {
        viewModel.searchQuery
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            query = searchQuery.value,
            onQueryChange = { query ->
                viewModel.onQueryChange( query )
            },
            onSearch = { query ->
                viewModel.onSearch( query )
            },
            active = false,
            onActiveChange = {},
            placeholder = {
                Text(
                    text = "Type a word...",
                    style = Typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_24px),
                    contentDescription = "Search",
                    modifier = Modifier
                        .size( 40.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            colors = SearchBarDefaults.colors(containerColor = MaterialTheme.colorScheme.background),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth(0.9f)
        ) {
        }

        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(topStart = AppBarRounded, topEnd = AppBarRounded),
            modifier = Modifier
                .fillMaxSize()
        ) {
            DictionaryBody( viewModel )
        }
    }
}

@Composable
fun DictionaryBody(
    viewModel: DictionaryScreenVM
) {
    val words = remember {
        viewModel.words
    }

    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        item {
//            CommonButton(
//                onClick = { Log.d("CommonButton", "Cliked")},
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = "EN",
//                    style = Typography.headlineSmall,
//                    color = MaterialTheme.colorScheme.onPrimary)
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_arrow_forward_48px),
//                    contentDescription = stringResource(R.string.direction_of_translation),
//                    modifier = Modifier
//                        .size(30.dp)
//                )
//                Text(
//                    text = "CZ",
//                    style = Typography.headlineSmall,
//                    color = MaterialTheme.colorScheme.onPrimary)
//            }
//        }

        var lastCharacter = ""

        if (words.isEmpty()) {
            item {
                EmptyDictionaryScreen( viewModel )
            }
        } else {
            items(items = words, key = {word -> word.value.value}) {word ->
                val currentCharacter = word.value.value.first().toString().uppercase()
                if ( currentCharacter != lastCharacter ) {
                    lastCharacter = currentCharacter
                    Divider(text = currentCharacter)
                }

                ItemCard(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(vertical = 1.dp)
                        .heightIn(30.dp)
                        .fillMaxWidth(DictionaryWidthScaleBody),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row {
                        Text(
                            text = word.value.value,
                            style = Typography.headlineSmall,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EmptyDictionaryScreen(
    viewModel: DictionaryScreenVM
) {
    val searchQuery = remember {
        viewModel.searchQuery
    }

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
            onClick = {
                viewModel.addWord(searchQuery.value)
            },
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

@Composable
fun Divider( text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(DictionaryWidthScaleBody)
            .padding(top = 24.dp, bottom = 10.dp)
    ) {
        Text(
            text = text,
            style = Typography.labelMedium,
            modifier = Modifier.align(Alignment.Start),
            color = MaterialTheme.colorScheme.outline
        )
        Divider( thickness = 1.dp, color = MaterialTheme.colorScheme.outline, modifier = Modifier.fillMaxWidth() )
    }
}

