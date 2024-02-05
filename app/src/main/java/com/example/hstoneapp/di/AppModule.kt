package com.example.hstoneapp.di

import com.example.hstoneapp.presentation.viewmodel.MainViewModel
import com.example.hstoneapp.data.datasource.CardDataSourceImp
import com.example.hstoneapp.domain.useCase.CardDataUseCase
import com.example.hstoneapp.domain.useCase.CardDataUseCaseImp
import com.example.hstoneapp.presentation.viewmodel.DetailsViewModel
import com.example.hstoneapp.data.CardService
import com.example.hstoneapp.data.datasource.CardDataSource
import com.example.hstoneapp.data.repository.CardDataRepository
import com.example.hstoneapp.data.repository.CardDataRepositoryImp
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit


val appModule = module {
    factory<CardDataSource> { CardDataSourceImp(service = get()) }
    factory<CardDataRepository> { CardDataRepositoryImp(dataSource = get()) }
    factory<CardDataUseCase> { CardDataUseCaseImp(repository = get()) }
    viewModel { MainViewModel(useCase = get()) }
    viewModel { DetailsViewModel(useCase = get()) }

    factory<CardService> {
        get<Retrofit>()
            .create(CardService::class.java)
    }
}

val applicationModules =
    listOf(
        appModule, networkServiceModule
    )