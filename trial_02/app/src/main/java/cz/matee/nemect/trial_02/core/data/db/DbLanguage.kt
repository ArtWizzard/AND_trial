package cz.matee.nemect.trial_02.core.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Language")
data class DbLanguage(
    @PrimaryKey val sign: String,
    val name: String
)
