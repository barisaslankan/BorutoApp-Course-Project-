package com.barisaslankan.borutoapp.data.repository

import androidx.paging.PagingData
import com.barisaslankan.borutoapp.domain.model.Hero
import com.barisaslankan.borutoapp.domain.repository.DataStoreOperations
import com.barisaslankan.borutoapp.domain.repository.LocalDataSource
import com.barisaslankan.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStoreOperations : DataStoreOperations,
    private val local: LocalDataSource,
    private val remote : RemoteDataSource
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId = heroId)
    }

    suspend fun saveOnboardingState(completed:Boolean){
        dataStoreOperations.saveOnboardingState(completed = completed)
    }

    fun readOnboardingState() : Flow<Boolean>{
        return dataStoreOperations.readOnboardingState()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remote.searchHeroes(query = query)
    }

}