package com.barisaslankan.borutoapp.domain.use_cases.read_onboarding

import com.barisaslankan.borutoapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnboardingUseCase (
    private val repository: Repository
){
    operator fun invoke() : Flow<Boolean> {
        return repository.readOnboardingState()
    }
}