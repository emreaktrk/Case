package com.emreaktrk.data.word

import com.emreaktrk.core.model.Token
import com.emreaktrk.core.model.WordModel

interface IWordRepository {
    suspend fun shuffle(token: Token): List<WordModel>
}