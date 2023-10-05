package cz.matee.nemect.trial_02.core.database

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import cz.matee.nemect.trial_02.presentation.ui.theme.value.DarkMode


class DB {
    //          VALUES
    private val languages = mutableStateListOf(
        Language(mutableStateOf("English"), mutableStateOf("EN")),
        Language(mutableStateOf("Germany"), mutableStateOf("NE")),
        Language(mutableStateOf("Czech"), mutableStateOf("CZ")),
    )

    //    val darkMode = MutableStateFlow(DarkMode.SYSTEM)
    // How can i provide darkMode state to trigger recomposition when change? Without directly accessing!
//    val darkMode: MutableState<DarkMode> = mutableStateOf(DarkMode.SYSTEM)

    //          PROVIDERS
//    fun getDarkModeStream(): StateFlow<DarkMode> {
//        return flowOf(
//            darkMode
//        ) as StateFlow<DarkMode>
//    }
//    fun getDarkModeStream(): Flow<DarkMode> {
//        return flowOf(
//            darkMode
//        )
//    }
//    fun getDarkModeStream(): MutableStateFlow<DarkMode> {
//        return darkMode
//    }

//    fun provideDarkModeState(): DarkMode {
//        return darkMode.value
//    }
//
//    fun changeDarkMode(mode: DarkMode) {
//        darkMode.value = mode
//    }

    fun provideLanguages(): MutableList<Language> {
        return languages
    }

    fun provideLanguage(
        languageCode: String
    ): Language {
        val lang = languages.find { it.sign.value == languageCode.uppercase() }
        if (lang == null) throw NullPointerException("Failed to find language ${languageCode.uppercase()}.")
        else return lang
    }

    fun provideWords(
        languageCode: String
    ): MutableList<Word> {
        return languages.find { it.sign.value == languageCode.uppercase() }?.words
            ?: mutableListOf()
    }


    //MODIFIERS
    fun addLanguage(
        language: String, sign: String
    ) {
        languages.add(Language(mutableStateOf(language), mutableStateOf(sign)))
    }

    fun addWord(
        languageSign: String, word: Word
    ) {
        val comparator = WordComparator()

        val refL = languages.find { it.sign.value == languageSign.uppercase() }
            ?: throw NullPointerException("Unable to add word to language $languageSign")

        refL.words.add(word)
        refL.words.sortWith(comparator)
    }
}
