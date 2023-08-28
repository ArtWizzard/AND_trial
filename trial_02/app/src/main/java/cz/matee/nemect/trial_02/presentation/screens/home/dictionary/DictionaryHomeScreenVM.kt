package cz.matee.nemect.trial_02.presentation.screens.home.dictionary

import androidx.lifecycle.ViewModel
import cz.matee.nemect.trial_02.core.database.DB
import cz.matee.nemect.trial_02.core.database.Word

class DictionaryHomeScreenVM (
    private val database: DB
): ViewModel() {
    val nothingFound: Boolean
        get() {
            return database.provideWords("en").isEmpty()
        }

    fun getWords(): MutableList<Word> {
        return database.provideWords("en")
    }
}