package com.example.hstoneapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hstoneapp.domain.model.CardByFilterEntity
import com.example.hstoneapp.domain.useCase.CardDataUseCase
import com.example.hstoneapp.presentation.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val useCase: CardDataUseCase,
    ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val scope = CoroutineScope(ioDispatcher)

    private val _uiState = MutableStateFlow<UiState<List<CardByFilterEntity>>>(
        UiState.Loading
    )
    val uiState: StateFlow<UiState<List<CardByFilterEntity>>> get() = _uiState


    fun setItemName(itemName: String, filterName: String) {
        when (filterName) {
            FiltersName.CLASSES.valueType -> {
                getClassesList(itemName)
            }
            FiltersName.RACES.valueType -> {
                getRacesList(itemName)
            }
            FiltersName.TYPES.valueType -> {
                getTypesList(itemName)
            }
            FiltersName.FACTIONS.valueType -> {
                getFactionsList(itemName)
            }
            FiltersName.SETS.valueType -> {
                getSetsList(itemName)
            }
            FiltersName.QUALITIES.valueType -> {
                getQualityList(itemName)
            }
        }
    }

    private fun getRacesList(itemName: String) {
        scope.launch {

            useCase.getRacesFiltersData(itemName)
                .catch { errorMessage ->
                    _uiState.value = UiState.Error(errorMessage)
                }
                .collect { cardsList ->
                    _uiState.value = UiState.Success(cardsList)
                }
        }
    }

    private fun getClassesList(itemName: String) {
        scope.launch {

            useCase.getClassesFiltersData(itemName)
                .catch { errorMessage ->
                    _uiState.value = UiState.Error(errorMessage)
                }
                .collect { cardsList ->
                    _uiState.value = UiState.Success(cardsList)
                }
        }
    }


    private fun getQualityList(itemName: String) {
        scope.launch {

            useCase.getQualityFiltersData(itemName)
                .catch { errorMessage ->
                    _uiState.value = UiState.Error(errorMessage)
                }
                .collect { cardsList ->
                    _uiState.value = UiState.Success(cardsList)
                }
        }
    }

    private fun getSetsList(itemName: String) {
        scope.launch {

            useCase.getSetsFiltersData(itemName)
                .catch { errorMessage ->
                    _uiState.value = UiState.Error(errorMessage)
                }
                .collect { cardsList ->
                    _uiState.value = UiState.Success(cardsList)
                }
        }
    }

    private fun getFactionsList(itemName: String) {
        scope.launch {

            useCase.getFactionsFiltersData(itemName)
                .catch { errorMessage ->
                    _uiState.value = UiState.Error(errorMessage)
                }
                .collect { cardsList ->
                    _uiState.value = UiState.Success(cardsList)
                }
        }
    }

    private fun getTypesList(itemName: String) {
        scope.launch {

            useCase.getTypesFiltersData(itemName)
                .catch { errorMessage ->
                    _uiState.value = UiState.Error(errorMessage)
                }
                .collect { cardsList ->
                    _uiState.value = UiState.Success(cardsList)
                }
        }
    }
}

enum class FiltersName(var valueType: String) {
    CLASSES("Classes"),
    RACES("Races"),
    TYPES("Types"),
    FACTIONS("Factions"),
    SETS("Sets"),
    QUALITIES("Qualities");
}