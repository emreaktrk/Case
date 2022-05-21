package com.emreaktrk.data.word

import com.emreaktrk.core.model.Token
import com.emreaktrk.core.model.WordModel
import kotlinx.coroutines.flow.Flow

interface IWordRepository {
    suspend fun shuffle(token: Token): List<WordModel>

    suspend fun shuffleAsFlow(token: Token): Flow<List<WordModel>>
}