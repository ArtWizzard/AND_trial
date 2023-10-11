package cz.matee.nemect.trial_02.presentation.screens.home.dictionary

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DictionaryScreenVM (
): ViewModel() {

    val searchQuery = mutableStateOf("")
//    val words = database.provideWords("en").toMutableStateList()

    fun onQueryChange(text: String) {
        searchQuery.value = text
//        onSearch( text )
    }

//    fun onSearch( text: String ) {
//        words.clear()
//        words.addAll(
//            if (text.isEmpty())
//                database.provideWords("en").toMutableStateList()
//            else
//                database.provideWords("en").filter { it.value.value.contains(text, ignoreCase = true) }.toMutableStateList()
//        )
//    }
//
//    fun addWord( text: String? ) {
//        if (!text?.isEmpty()!!) {
//            searchQuery.value = ""
//            database.addWord(
//                languageSign = "en",
//                word = Word(mutableStateOf(text ?: ""), mutableStateOf(""))
//            )
//            words.clear()
//            words.addAll(database.provideWords("en").toMutableStateList())
//        }
//    }
}