package com.example.computerarchitecture.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.computerarchitecture.data.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


/**
 * The view model for the multiprocessor systems screen
 *
 * @param userPreferencesRepository The repository for user preferences
 */
@HiltViewModel
class MultiprocessorSystemsViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    val isStudyMode: StateFlow<Boolean> = userPreferencesRepository.isStudyMode.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = false
    )
}