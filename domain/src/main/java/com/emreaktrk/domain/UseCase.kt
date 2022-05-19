package com.emreaktrk.domain

import kotlinx.coroutines.flow.Flow

abstract class UseCase<I, O> {
    abstract fun invoke(input: I): Flow<O>
}