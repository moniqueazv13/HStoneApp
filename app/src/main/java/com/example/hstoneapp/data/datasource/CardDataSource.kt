package com.example.hstoneapp.data.datasource

import com.example.hstoneapp.domain.model.CardByFilterEntity
import com.example.hstoneapp.domain.model.InfoFilterEntity
import kotlinx.coroutines.flow.Flow

interface CardDataSource {
    fun fetchCardFiltersData(): Flow<InfoFilterEntity>
    fun fetchRacesFiltersData(raceName: String): Flow<List<CardByFilterEntity>>
    fun fetchClassesFiltersData(className: String): Flow<List<CardByFilterEntity>>
    fun fetchQualityFiltersData(qualityName: String): Flow<List<CardByFilterEntity>>
    fun fetchSetsFiltersData(setsName: String): Flow<List<CardByFilterEntity>>
    fun fetchFactionsFiltersData(factionsName: String): Flow<List<CardByFilterEntity>>
    fun fetchTypesFiltersData(typesName: String): Flow<List<CardByFilterEntity>>
}