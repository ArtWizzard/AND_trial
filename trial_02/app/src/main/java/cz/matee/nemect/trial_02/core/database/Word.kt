package cz.matee.nemect.trial_02.core.database

import androidx.compose.runtime.MutableState

data class Word(
    val value: MutableState<String>,
    val meaning: MutableState<String>,
    val groups: MutableList<String> = mutableListOf()
)

class WordComparator : Comparator<Word>{
    override fun compare(w1: Word, w2: Word): Int {
        return w1.value.value.compareTo(w2.value.value, ignoreCase = true)
    }
}
