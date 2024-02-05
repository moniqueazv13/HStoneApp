package com.example.hstoneapp.data.datasource

import com.example.hstoneapp.data.CardService
import com.example.hstoneapp.presentation.utils.call
import com.example.hstoneapp.domain.model.InfoFilterEntity

class CardDataSourceImp(private val service: CardService) : CardDataSource {
    override fun fetchCardFiltersData() = call {
        service.fetchCardAllFilters()
    }

    override fun fetchRacesFiltersData(raceName: String) = call {
        service.fetchRacesFiltersData(raceName)
    }

    override fun fetchClassesFiltersData(className: String) = call {
        service.fetchClassesFiltersData(className)
    }

    override fun fetchQualityFiltersData(qualityName: String) = call {
        service.fetchQualityFiltersData(qualityName)
    }

    override fun fetchSetsFiltersData(setsName: String) = call {
        service.fetchSetsFiltersData(setsName)
    }

    override fun fetchFactionsFiltersData(factionsName: String) = call {
        service.fetchFactionFiltersData(factionsName)
    }

    override fun fetchTypesFiltersData(typesName: String) = call {
        service.fetchTypesFiltersData(typesName)
    }
}