package cz.matee.nemect.trial_02.core.database

import androidx.compose.runtime.MutableState

data class Language(
    val name: MutableState<String>,
    val sign: MutableState<String>,
    val words: MutableList<Word> = mutableListOf()
)
