package cz.matee.nemect.trial_02.core.database

import androidx.compose.runtime.mutableStateListOf


class DB {
    private val languages = mutableStateListOf<Language>(
        Language("English","EN"),
        Language("Germany","NE"),
        Language("Czech","CZ")
    )

    fun provideLanguages(): MutableList<Language> {
        return languages
    }

    fun addLanguage(
        language: String,
        sign: String
    ) {
        languages.add(Language(language, sign))
    }

    fun addGroup(
        languageSign: String,
        name: String
    ) {
        val ref = languages.find { it.sign == languageSign }

        if (ref == null) {
            throw NullPointerException("Failed to find language ${languageSign}.")
        } else {
            ref.run { groups.add( Group(name) ) }
        }
    }

    fun addWord(
        languageSign: String,
        group: String,
        word: Word
    ) {
        val refL = languages.find { it.sign == languageSign }
        val refG = refL?.groups?.find { it.name == group }

        if ( refL == null || refG == null )
            throw NullPointerException("Unable to add word to group ${group} in language ${languageSign}")
        refG.words.add(word)

    }
}
