package com.barisaslankan.borutoapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.barisaslankan.borutoapp.domain.repository.DataStoreOperations
import com.barisaslankan.borutoapp.util.Constants.PREFERENCES_KEY
import com.barisaslankan.borutoapp.util.Constants.PREFERENCES_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl(context : Context) : DataStoreOperations {

    private object PreferencesKey{
        val onboardingKey = booleanPreferencesKey(PREFERENCES_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnboardingState(completed: Boolean) {
        dataStore.edit {preferences ->
            preferences[PreferencesKey.onboardingKey] = completed
        }
    }

    override fun readOnboardingState(): Flow<Boolean> {
        return dataStore.data
            .catch {exception ->
                if(exception is IOException){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKey.onboardingKey] ?: false
                onBoardingState
            }
    }
}