package com.example.computerarchitecture.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * A repository for user preferences.
 *
 * @param dataStore The data store for user preferences
 */
class UserPreferencesRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    val isStudyMode: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[IS_STUDY_MODE] ?: false
        }

    private companion object {
        val IS_STUDY_MODE = booleanPreferencesKey("is_study_mode")
    }

    /**
     * Saves the user's preference for the study mode layout
     */
    suspend fun saveLayoutPreference(isStudyMode: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_STUDY_MODE] = isStudyMode
        }
    }
}