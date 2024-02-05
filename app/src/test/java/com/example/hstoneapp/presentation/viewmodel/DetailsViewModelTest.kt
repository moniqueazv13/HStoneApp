package com.example.hstoneapp.presentation.viewmodel

import com.example.hstoneapp.domain.model.CardByFilterEntity
import com.example.hstoneapp.domain.useCase.CardDataUseCase
import com.example.hstoneapp.presentation.UiState
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

class DetailsViewModelTest {

    private val cardDataUseCase = mockk<CardDataUseCase>()
    private val cardByFilterEntityListMocked = listOf(
        CardByFilterEntity("https://d15f34w2p8l1cc.cloudfront.net/hearthstone/ee2e355e689f8c074216ba922616fed718e5d55211816bf58d95b1f37e7cbf8c.png")
    )

    @Test
    fun `Whenever Classes chosen name filter should return a CardByFilterEntity`() =
        runTest {
            val dispatcher = StandardTestDispatcher(testScheduler)
            val viewModelMocked = DetailsViewModel(cardDataUseCase, dispatcher)

            coEvery { cardDataUseCase.getClassesFiltersData("Druid") } returns flow {
                emit(
                    cardByFilterEntityListMocked
                )
            }
            viewModelMocked.setItemName("Druid", FiltersName.CLASSES.valueType)
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Loading)
            advanceUntilIdle()

            coVerify { cardDataUseCase.getClassesFiltersData("Druid") }
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Success(cardByFilterEntityListMocked))
        }

    @Test
    fun `Whenever Races chosen name filter should return a CardByFilterEntity`() =
        runTest {
            val dispatcher = StandardTestDispatcher(testScheduler)
            val viewModelMocked = DetailsViewModel(cardDataUseCase, dispatcher)

            coEvery { cardDataUseCase.getRacesFiltersData("Orc") } returns flow {
                emit(
                    cardByFilterEntityListMocked
                )
            }
            viewModelMocked.setItemName("Orc", FiltersName.RACES.valueType)
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Loading)
            advanceUntilIdle()

            coVerify { cardDataUseCase.getRacesFiltersData("Orc") }
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Success(cardByFilterEntityListMocked))
        }

    @Test
    fun `Whenever Sets chosen name filter should return a CardByFilterEntity`() =
        runTest {
            val dispatcher = StandardTestDispatcher(testScheduler)
            val viewModelMocked = DetailsViewModel(cardDataUseCase, dispatcher)

            coEvery { cardDataUseCase.getSetsFiltersData("Basic") } returns flow {
                emit(
                    cardByFilterEntityListMocked
                )
            }
            viewModelMocked.setItemName("Basic", FiltersName.SETS.valueType)
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Loading)
            advanceUntilIdle()

            coVerify { cardDataUseCase.getSetsFiltersData("Basic") }

        }

    @Test
    fun `Whenever Types chosen name filter should return a CardByFilterEntity`() =
        runTest {
            val dispatcher = StandardTestDispatcher(testScheduler)
            val viewModelMocked = DetailsViewModel(cardDataUseCase, dispatcher)

            coEvery { cardDataUseCase.getTypesFiltersData("Minion") } returns flow {
                emit(
                    cardByFilterEntityListMocked
                )
            }
            viewModelMocked.setItemName("Minion", FiltersName.TYPES.valueType)
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Loading)
            advanceUntilIdle()

            coVerify { cardDataUseCase.getTypesFiltersData("Minion") }
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Success(cardByFilterEntityListMocked))
        }

    @Test
    fun `Whenever Factions chosen name filter should return a CardByFilterEntity`() =
        runTest {
            val dispatcher = StandardTestDispatcher(testScheduler)
            val viewModelMocked = DetailsViewModel(cardDataUseCase, dispatcher)

            coEvery { cardDataUseCase.getFactionsFiltersData("Horde") } returns flow {
                emit(
                    cardByFilterEntityListMocked
                )
            }
            viewModelMocked.setItemName("Horde", FiltersName.FACTIONS.valueType)
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Loading)
            advanceUntilIdle()

            coVerify { cardDataUseCase.getFactionsFiltersData("Horde") }
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Success(cardByFilterEntityListMocked))
        }

    @Test
    fun `Whenever Qualities chosen name filter should return a CardByFilterEntity`() =
        runTest {
            val dispatcher = StandardTestDispatcher(testScheduler)
            val viewModelMocked = DetailsViewModel(cardDataUseCase, dispatcher)

            coEvery { cardDataUseCase.getQualityFiltersData("Rare") } returns flow {
                emit(
                    cardByFilterEntityListMocked
                )
            }
            viewModelMocked.setItemName("Rare", FiltersName.QUALITIES.valueType)
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Loading)
            advanceUntilIdle()

            coVerify { cardDataUseCase.getQualityFiltersData("Rare") }
            Truth.assertThat(viewModelMocked.uiState.value)
                .isEqualTo(UiState.Success(cardByFilterEntityListMocked))
        }
}