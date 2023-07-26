package cz.matee.nemect.trial_01.database

data class UserMessage(
    val user: User = User(),
    val text: String = "Random text..."
)
