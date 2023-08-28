package cz.matee.nemect.trial_02.core.database

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.text.toUpperCase
import java.lang.Character.toUpperCase


class DB {
    //          VALUES
    private val languages = mutableStateListOf<Language>(
        Language("English","EN"),
        Language("Germany","NE"),
        Language("Czech","CZ")
    )

    //          PROVIDERS
    fun provideLanguages(): MutableList<Language> {
        return languages
    }

    fun provideLanguage(
        languageCode: String
    ): Language {
        val lang = languages.find { it.sign == languageCode.uppercase() }
        if ( lang == null )
            throw NullPointerException("Failed to find language ${languageCode.uppercase()}.")
        else
            return lang
    }

    fun provideWords(
        languageCode: String
    ): MutableList<Word> {
        val groups = provideLanguage(languageCode).groups
        val words = mutableListOf<Word>()

        groups.forEach {
            words.addAll(it.words)
        }

        return words
    }



    //          MODIFIERS
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
