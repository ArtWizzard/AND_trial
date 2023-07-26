package cz.matee.nemect.trial_01.database

data class UserChatPreview(
    val user: User = User(),
    val lastMessage: String = "No conversation yet"
)
