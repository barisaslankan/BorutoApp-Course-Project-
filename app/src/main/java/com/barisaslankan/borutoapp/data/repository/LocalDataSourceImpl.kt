package com.barisaslankan.borutoapp.data.repository

import com.barisaslankan.borutoapp.data.local.BorutoDatabase
import com.barisaslankan.borutoapp.domain.model.Hero
import com.barisaslankan.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getHero(heroId = heroId)
    }
}