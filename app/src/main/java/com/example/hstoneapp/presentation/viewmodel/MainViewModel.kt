package com.example.hstoneapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hstoneapp.domain.model.InfoFilterEntity
import com.example.hstoneapp.domain.useCase.CardDataUseCase
import com.example.hstoneapp.presentation.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: CardDataUseCase,
    ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val scope = CoroutineScope(ioDispatcher)

    private val _uiState = MutableStateFlow<UiState<InfoFilterEntity>>(
        UiState.Loading
    )
    val uiState: StateFlow<UiState<InfoFilterEntity>> get() = _uiState

    private var infoFilterLis: Map<String, List<String>> = emptyMap()

    fun getInfo() {
        scope.launch {
            useCase.getCardFiltersData()
                .catch { errorMessage ->
                    _uiState.value = UiState.Error(errorMessage)
                }
                .collect { info ->
                    _uiState.value = UiState.Success(info)
                }
        }
    }


    private fun getListInfoFilters(): List<String> =
        listOf("Classes", "Sets", "Types", "Factions", "Qualities", "Races", "Locales")

    fun setInfoResult(info: InfoFilterEntity) {

        val localesList = listOf(
            info.locales?.deDe,
            info.locales?.enGB,
            info.locales?.enUs,
            info.locales?.esEs,
            info.locales?.esMX,
            info.locales?.frFr,
            info.locales?.itIt,
            info.locales?.plPl,
            info.locales?.ruRu,
            info.locales?.zhTw,
            info.locales?.jaJp,
            info.locales?.thTh
        )

        infoFilterLis = mapOf(
            Pair(getListInfoFilters()[0], info.classes),
            Pair(getListInfoFilters()[1], info.sets),
            Pair(getListInfoFilters()[2], info.types),
            Pair(getListInfoFilters()[3], info.factions),
            Pair(getListInfoFilters()[4], info.qualities),
            Pair(getListInfoFilters()[5], info.races),
            Pair(getListInfoFilters()[6], localesList)
        ) as Map<String, List<String>>
    }

    fun getCardInfoList(): Map<String, List<String>> {
        return infoFilterLis
    }
}