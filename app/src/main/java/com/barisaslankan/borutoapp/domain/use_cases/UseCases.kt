package com.barisaslankan.borutoapp.domain.use_cases

import com.barisaslankan.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.barisaslankan.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.barisaslankan.borutoapp.domain.use_cases.read_onboarding.ReadOnboardingUseCase
import com.barisaslankan.borutoapp.domain.use_cases.save_onboarding.SaveOnboardingUseCase
import com.barisaslankan.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnboardingUseCase: SaveOnboardingUseCase,
    val readOnboardingUseCase: ReadOnboardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase

)
