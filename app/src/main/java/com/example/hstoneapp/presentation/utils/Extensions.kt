package com.example.hstoneapp.presentation.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

fun <T> call(block: suspend FlowCollector<T>.() -> T): Flow<T> = flow {
    emit(block())
}