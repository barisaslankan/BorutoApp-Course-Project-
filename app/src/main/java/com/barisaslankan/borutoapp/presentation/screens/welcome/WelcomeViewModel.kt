package com.barisaslankan.borutoapp.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barisaslankan.borutoapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel()
{

    fun saveOnboardingState(completed : Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            useCases.saveOnboardingUseCase(completed = completed)
        }
    }

}