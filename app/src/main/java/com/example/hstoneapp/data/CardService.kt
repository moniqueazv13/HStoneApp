package com.example.hstoneapp.data

import com.example.hstoneapp.domain.model.CardByFilterEntity
import com.example.hstoneapp.domain.model.InfoFilterEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {

    @GET("info")
    suspend fun fetchCardAllFilters(): InfoFilterEntity

    @GET("cards/races/{raceName}")
    suspend fun fetchRacesFiltersData(@Path("raceName") raceName: String): List<CardByFilterEntity>

    @GET("cards/classes/{className}")
    suspend fun fetchClassesFiltersData(@Path("className") className: String): List<CardByFilterEntity>

    @GET("cards/qualities/{qualityName}")
    suspend fun fetchQualityFiltersData(@Path("qualityName") qualityName: String): List<CardByFilterEntity>

    @GET("cards/sets/{setsName}")
    suspend fun fetchSetsFiltersData(@Path("setsName") setsName: String): List<CardByFilterEntity>


    @GET("cards/factions/{factionName}")
    suspend fun fetchFactionFiltersData(@Path("factionName") factionName: String): List<CardByFilterEntity>

    @GET("cards/types/{typeName}")
    suspend fun fetchTypesFiltersData(@Path("typeName") typeName: String): List<CardByFilterEntity>

}
