package com.example.hstoneapp.di

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClientBuilder {

    companion object {

        fun <S> createService(
            serviceClass: Class<S>,
            rootUrl: String,
            readTimeoutInMills: Long = 150000L,
            gson: Gson = Gson(),
            vararg interceptors: Interceptor
        ): S {

            val httpClientBuilder = OkHttpClient.Builder()

            interceptors.iterator().forEach { interceptor -> httpClientBuilder.addInterceptor(interceptor) }

            val client = httpClientBuilder
                .readTimeout(readTimeoutInMills, TimeUnit.MILLISECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build()

            val retrofit = getClientBuilder(rootUrl, gson)
                .client(client)
                .build()

            return retrofit.create(serviceClass)
        }

        private fun getClientBuilder(retrofitBaseUrl: String, gson: Gson): Retrofit.Builder {
            return Retrofit.Builder()
                .baseUrl(retrofitBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
        }
    }
}
