package com.example.hstoneapp.di

import com.example.hstoneapp.presentation.utils.Constants.HEADER_NAME
import com.example.hstoneapp.presentation.utils.Constants.HEADER_VALUE
import okhttp3.Interceptor
import okhttp3.Response

class ClientIdInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .addHeader(HEADER_NAME, HEADER_VALUE)
            .build()

        return chain.proceed(newRequest)
    }
}