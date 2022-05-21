package com.emreaktrk.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class UseCase<I, O> {
    protected abstract suspend fun onInvoke(input: I): Flow<O>

    suspend operator fun invoke(params: I) = onInvoke(params).flowOn(Dispatchers.IO)
}

object NoParams