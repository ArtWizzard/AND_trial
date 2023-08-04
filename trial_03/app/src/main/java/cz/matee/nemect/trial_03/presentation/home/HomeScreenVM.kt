package cz.matee.nemect.trial_03.presentation.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_03.domain.FilterChipState

class HomeScreenVM : ViewModel() {
    // filter chips
    val chips = listOf(
        FilterChipState("Music", mutableStateOf(false)),
        FilterChipState("Podcasts", mutableStateOf(false)),
        FilterChipState("Shows", mutableStateOf(false)),
        FilterChipState("Albs", mutableStateOf(false)),
        FilterChipState("Favorite", mutableStateOf(false))
    )

    fun changeSearchChip( chip: FilterChipState ) {
        chip.selected.value = !chip.selected.value

        Log.d("Filter chip ${chip.text}","Changed to: ${chip.selected.value}")
    }
}

