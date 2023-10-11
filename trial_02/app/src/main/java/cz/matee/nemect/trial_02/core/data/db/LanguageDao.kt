package cz.matee.nemect.trial_02.core.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LanguageDao {

    @Query("SELECT * FROM language")
    suspend fun getLanguages(): List<DbLanguage>

    @Query("SELECT * FROM language WHERE sign = :sign")
    suspend fun getLanguage(sign: String): DbLanguage?

    @Insert
    suspend fun insert(languages: List<DbLanguage>)

    @Query("DELETE FROM language")
    suspend fun deleteAll()
}