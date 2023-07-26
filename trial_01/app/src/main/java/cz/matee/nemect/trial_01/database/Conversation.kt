package cz.matee.nemect.trial_01.database

data class Conversation(
    val users: List<User>,
    val messages: List<UserMessage>
)


