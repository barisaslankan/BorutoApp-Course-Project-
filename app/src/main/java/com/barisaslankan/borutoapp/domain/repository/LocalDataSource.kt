package com.barisaslankan.borutoapp.domain.repository

    import com.barisaslankan.borutoapp.domain.model.Hero

    interface LocalDataSource {
        suspend fun getSelectedHero(heroId: Int): Hero
    }
