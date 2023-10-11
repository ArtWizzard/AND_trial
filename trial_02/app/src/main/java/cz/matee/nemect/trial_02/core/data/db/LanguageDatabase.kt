package cz.matee.nemect.trial_02.core.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [DbLanguage::class])
abstract class LanguageDatabase : RoomDatabase() {

    abstract fun languageDao(): LanguageDao

    companion object {

        fun instance(context: Context): LanguageDatabase {
            return Room.databaseBuilder(context, LanguageDatabase::class.java, "language.db").build()
        }
    }
}