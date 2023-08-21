package cz.matee.nemect.trial_02.presentation.ui.components.sideSheet

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class SideSheetState(
    private var currentState: MutableState<SideSheetValue> = mutableStateOf( SideSheetValue.Hidden )
) {

    val isVisible: Boolean
        get() = currentState.value != SideSheetValue.Hidden

    fun expand() {
        currentState.value = SideSheetValue.Expanded
    }

    fun hide() {
        currentState.value = SideSheetValue.Hidden
    }
}

