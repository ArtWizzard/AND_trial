package cz.matee.nemect.trial_02.core.data.db

import cz.matee.nemect.trial_02.core.data.domain.Language
import cz.matee.nemect.trial_02.core.data.LanguageLocalDataSource

class LanguageRoomDataSource (private val languageDao: LanguageDao) : LanguageLocalDataSource{

    override suspend fun getLanguages(): List<Language> {
        return languageDao.getLanguages().map { it.toLanguage() }
    }

    private fun DbLanguage.toLanguage(): Language {
        return Language(
            sign = sign,
            name = name
        )
    }

    override suspend fun getLanguage(sign: String): Language? {
        return languageDao.getLanguage(sign)?.toLanguage()
    }

    override suspend fun insert(languages: List<Language>) {
        languageDao.insert( languages.map { it.toDb() })
    }

    private fun Language.toDb(): DbLanguage {
        return DbLanguage(
            sign = sign,
            name = name
        )
    }

    override suspend fun deleteAll() {
        languageDao.deleteAll()
    }
}