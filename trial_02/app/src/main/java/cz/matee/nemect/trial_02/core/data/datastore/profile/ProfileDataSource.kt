package cz.matee.nemect.trial_02.core.data.datastore.profile

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import cz.matee.nemect.trial_02.presentation.ui.theme.value.DarkMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class ProfileDataSource (
    val app: Application
){
    private val appContext: Context get() = app

    private val Context.dataStore by preferencesDataStore("wordformer_datastore")
    private val DARK_MODE_KEY = stringPreferencesKey("name")

    fun getDarkModeStream(): Flow<DarkMode> {
        return appContext.dataStore.data
            .map { prefs ->
                val savedDarkModeName = prefs[DARK_MODE_KEY]
                if (savedDarkModeName != null) {
                    DarkMode.valueOf(savedDarkModeName)
                } else {
                    DarkMode.SYSTEM
                }
            }
            .distinctUntilChanged()
    }

    suspend fun setDarkMode(darkMode: DarkMode) {
        appContext.dataStore.edit { prefs -> prefs[DARK_MODE_KEY] = darkMode.name }
    }
}