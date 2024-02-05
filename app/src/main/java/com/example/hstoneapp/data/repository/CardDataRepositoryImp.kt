package com.example.hstoneapp.data.repository

import com.example.hstoneapp.data.datasource.CardDataSource
import com.example.hstoneapp.domain.model.CardByFilterEntity
import com.example.hstoneapp.domain.model.InfoFilterEntity
import kotlinx.coroutines.flow.Flow

class CardDataRepositoryImp(private val dataSource: CardDataSource) : CardDataRepository {
    override fun getCardFiltersData(): Flow<InfoFilterEntity> = dataSource.fetchCardFiltersData()

    override fun getRacesFiltersData(raceName: String): Flow<List<CardByFilterEntity>> =
        dataSource.fetchRacesFiltersData(raceName)

    override fun getClassesFiltersData(className: String): Flow<List<CardByFilterEntity>> =
        dataSource.fetchClassesFiltersData(className)

    override fun getQualityFiltersData(qualityName: String): Flow<List<CardByFilterEntity>> =
        dataSource.fetchQualityFiltersData(qualityName)

    override fun getSetsFiltersData(setsName: String): Flow<List<CardByFilterEntity>> =
        dataSource.fetchSetsFiltersData(setsName)

    override fun getFactionsFiltersData(factionsName: String): Flow<List<CardByFilterEntity>> =
        dataSource.fetchFactionsFiltersData(factionsName)

    override fun getTypesFiltersData(typesName: String): Flow<List<CardByFilterEntity>> =
        dataSource.fetchTypesFiltersData(typesName)
}
