package cz.matee.nemect.trial_02.core.data

import cz.matee.nemect.trial_02.core.data.domain.Language

interface LanguageLocalDataSource {

    suspend fun getLanguages(): List<Language>

    suspend fun getLanguage(sign: String): Language?

    suspend fun insert(languages: List<Language>)

    suspend fun deleteAll()
}