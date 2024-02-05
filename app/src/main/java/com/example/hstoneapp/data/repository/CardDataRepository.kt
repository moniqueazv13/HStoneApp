package com.example.hstoneapp.data.repository

import com.example.hstoneapp.domain.model.CardByFilterEntity
import com.example.hstoneapp.domain.model.InfoFilterEntity
import kotlinx.coroutines.flow.Flow

interface CardDataRepository {
    fun getCardFiltersData(): Flow<InfoFilterEntity>
    fun getRacesFiltersData(raceName: String): Flow<List<CardByFilterEntity>>
    fun getClassesFiltersData(className: String): Flow<List<CardByFilterEntity>>
    fun getQualityFiltersData(qualityName: String): Flow<List<CardByFilterEntity>>
    fun getSetsFiltersData(setsName: String): Flow<List<CardByFilterEntity>>
    fun getFactionsFiltersData(factionsName: String): Flow<List<CardByFilterEntity>>
    fun getTypesFiltersData(typesName: String): Flow<List<CardByFilterEntity>>
}