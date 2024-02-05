package com.example.hstoneapp.di

import com.example.hstoneapp.data.CardService
import org.koin.dsl.module


val networkServiceModule = module {
    single {
        ApiClientBuilder.createService(
            CardService::class.java,
            "https://omgvamp-hearthstone-v1.p.rapidapi.com/",
            interceptors = arrayOf(ClientIdInterceptor())
        )
    }
}
