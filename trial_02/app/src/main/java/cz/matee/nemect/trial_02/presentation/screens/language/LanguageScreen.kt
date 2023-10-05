package cz.matee.nemect.trial_02.presentation.screens.language

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.matee.nemect.trial_02.R
import cz.matee.nemect.trial_02.core.database.Language
import cz.matee.nemect.trial_02.presentation.ui.components.appBars.CommonAppBar
import cz.matee.nemect.trial_02.presentation.ui.components.icons.CommonLargeIcon
import cz.matee.nemect.trial_02.presentation.ui.theme.AppBarRounded
import cz.matee.nemect.trial_02.presentation.ui.theme.LargeIconSize
import cz.matee.nemect.trial_02.presentation.ui.theme.Typography
import org.koin.androidx.compose.koinViewModel

@Composable
fun LanguageScreen(
    viewModel: LanguageVM = koinViewModel()
) {
    val languages = remember {
        viewModel._languages
    }

    // back button handle - exit
    val activity = (LocalContext.current as? Activity)
    BackHandler(onBack = {
        activity?.finish()
    })

    
    // --------------------------------------- DESIGN
    Box {
        Scaffold(
            topBar = {
                Surface( shape = RoundedCornerShape(
                    bottomStart = AppBarRounded,
                    bottomEnd = AppBarRounded),
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    CommonAppBar(
                        onMenuClick = { /*TODO*/ },
                        header = ""
                    )
                }
            },
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.surface),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                LanguageCard(
                    languages = languages,
                    viewModel = viewModel
                )

            }
        }

    }

}

@Composable
fun LanguageCard(
    languages: MutableList<Language>,
    viewModel: LanguageVM
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Card (
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            shape = RoundedCornerShape(40.dp),
            modifier = Modifier
                .padding(bottom = LargeIconSize / 2)
        ) {
            Text(
                text = stringResource(R.string.language),
                color = MaterialTheme.colorScheme.onBackground,
                style = Typography.headlineLarge,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = AppBarRounded * 2)
            )
            LazyColumn (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(10.dp, bottom = 70.dp)
            ) {
                items( items = languages ) {language ->
                    Spacer(modifier = Modifier.height(10.dp))
                    LanguageButton(
                        viewModel = viewModel,
                        language = language)
                }
            }
        }

        Surface (
            shape = CircleShape,
            modifier = Modifier
                .size(LargeIconSize)
                .align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.surface
        ){
            CommonLargeIcon(
                onClick = { viewModel.addNewUser() },
                drawableID = R.drawable.ic_add_outlined_24dp,
                contentDescriptor = stringResource(R.string.add_language),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun LanguageButton (
    viewModel: LanguageVM,
    language: Language
) {
    OutlinedButton(
        onClick = {
            viewModel.navigateToDictionary( language.sign.value  )
        },
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(50.dp),
        border = BorderStroke(
            1.dp,
            color = MaterialTheme.colorScheme.outline)
    ) {
        Text(
            text = language.name.value,
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.titleMedium
        )
    }
}