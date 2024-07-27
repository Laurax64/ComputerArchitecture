package com.example.computerarchitecture.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.computerarchitecture.data.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * The view model for the topics screen
 *
 * @param userPreferencesRepository The repository for user preferences
 */
@HiltViewModel
class TopicsViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    val isStudyMode: StateFlow<Boolean> = userPreferencesRepository.isStudyMode.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = false
    )

    /**
     * Saves the user's preference for the study mode layout
     *
     * @param isStudyMode The user's preference for the study mode layout
     */
    fun saveStudyModePreference(isStudyMode: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveLayoutPreference(isStudyMode)
        }
    }
}