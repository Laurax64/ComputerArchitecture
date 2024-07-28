package com.example.computerarchitecture.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
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
    val memorizedTopics: Flow<List<String>> = dataStore.data
        .map { preferences ->
            preferences[MEMORIZED_TOPICS]?.split(",") ?: emptyList()
        }

    private companion object {
        val IS_STUDY_MODE = booleanPreferencesKey("is_study_mode")
        val MEMORIZED_TOPICS = stringPreferencesKey("memorized_topics")
    }

    /**
     * Saves the user's preference for the study mode layout
     *
     * @param isStudyMode Weather the user is in study mode
     */
    suspend fun saveLayoutPreference(isStudyMode: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_STUDY_MODE] = isStudyMode
        }
    }

    /**
     * Saves the user's memorized topics
     *
     * @param topics The topics that the user has memorized
     */
    suspend fun saveMemorizedTopics(topics: List<Topic>) {
        dataStore.edit { preferences ->
            preferences[MEMORIZED_TOPICS] = topics.joinToString(",") { it.title }
        }
    }
}