package com.barisaslankan.borutoapp.domain.use_cases.save_onboarding

import com.barisaslankan.borutoapp.data.repository.Repository

class SaveOnboardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed : Boolean){
        repository.saveOnboardingState(completed = completed)
    }
}