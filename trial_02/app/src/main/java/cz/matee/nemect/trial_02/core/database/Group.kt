package cz.matee.nemect.trial_02.core.database

data class Group(
    val name: String,
    val words: MutableList<Word> = mutableListOf()
)
