package com.emreaktrk.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class UseCase<I, O> {
    protected abstract fun onInvoke(input: I): Flow<O>

    operator fun invoke(params: I) = onInvoke(params).flowOn(Dispatchers.IO)
}

object NoParams