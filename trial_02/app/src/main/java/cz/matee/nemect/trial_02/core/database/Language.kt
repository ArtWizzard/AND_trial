package cz.matee.nemect.trial_02.core.database

data class Language(
    val name: String,
    val sign: String,
    val groups: MutableSet<Group> = mutableSetOf()
)
