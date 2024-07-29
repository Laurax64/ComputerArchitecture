package com.example.computerarchitecture.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.computerarchitecture.data.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * The view model for the OpenMP screen
 *
 * @param userPreferencesRepository The repository for user preferences
 */
@HiltViewModel
class OpenMPViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    val isStudyMode: Boolean = runBlocking { userPreferencesRepository.isStudyMode.first() }
}