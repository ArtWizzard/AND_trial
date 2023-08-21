package cz.matee.nemect.trial_02.presentation.ui.components.sideSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import cz.matee.nemect.trial_02.presentation.ui.theme.AppBarRounded
import cz.matee.nemect.trial_02.presentation.ui.theme.BTransparent50
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


//// DOESN'T WORK
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun SideSheet1(
//    onDismiss: () -> Unit,
//    content: @Composable () -> Unit,
//    other: @Composable (PaddingValues) -> Unit
//) {
//    BottomSheetScaffold(
//        sheetContent = {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                content()
//                Spacer(modifier = Modifier.height(16.dp))
//                Button(
//                    onClick = {
//                        onDismiss()
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text("Close")
//                }
//            }
//        },
//        sheetShape = androidx.compose.material3.MaterialTheme,
//        sheetPeekHeight = 0.dp, // Set to zero to make it a side sheet
//        content = other
//    )
//}

// ASK - pointerInput detection

@Composable
fun SideSheet(
    scope: CoroutineScope,
    sideSheetState: SideSheetState,
    modifier: Modifier = Modifier,
    shade: Color = BTransparent50,
    widthProportion: Float = 0.5f,
    content: @Composable () -> Unit
    ) {

    Row(modifier = Modifier
        .background(shade)
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                scope.launch {
                    if (sideSheetState.isVisible) {
                        sideSheetState.hide()
                    }
                }
            })
        },
        horizontalArrangement = Arrangement.End
    ) {
        Column (
            modifier = modifier
                .clip(RoundedCornerShape(topStart = AppBarRounded, bottomStart = AppBarRounded))
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth(widthProportion)
                .fillMaxHeight()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {})
                }
        ) {
            content()
        }
    }
}

@Composable
fun rememberSideSheetState( value: SideSheetValue): SideSheetState {
    // ASK - return remembersaveable{} -> fails with crash
    return remember {
        SideSheetState( mutableStateOf (value) )
    }
}


