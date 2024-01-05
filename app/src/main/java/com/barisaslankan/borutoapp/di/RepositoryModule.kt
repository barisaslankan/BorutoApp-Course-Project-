package com.barisaslankan.borutoapp.di

import android.content.Context
import com.barisaslankan.borutoapp.data.repository.DataStoreOperationsImpl
import com.barisaslankan.borutoapp.data.repository.Repository
import com.barisaslankan.borutoapp.domain.repository.DataStoreOperations
import com.barisaslankan.borutoapp.domain.use_cases.UseCases
import com.barisaslankan.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.barisaslankan.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.barisaslankan.borutoapp.domain.use_cases.read_onboarding.ReadOnboardingUseCase
import com.barisaslankan.borutoapp.domain.use_cases.save_onboarding.SaveOnboardingUseCase
import com.barisaslankan.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context : Context
    ) : DataStoreOperations{
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ) : UseCases{
        return UseCases(
            saveOnboardingUseCase = SaveOnboardingUseCase(repository),
            readOnboardingUseCase = ReadOnboardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
    }

}