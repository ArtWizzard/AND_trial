package cz.matee.nemect.trial_03.domain

import androidx.compose.runtime.MutableState

data class FilterChipState(
    val text: String,
    val selected: MutableState<Boolean>
)