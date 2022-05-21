package com.emreaktrk.data.word

import com.emreaktrk.core.model.Token
import com.emreaktrk.core.model.WordModel
import javax.inject.Inject

class WordRepository @Inject constructor(
    private val remote: WordRemoteDataSource,
    private val local: WordLocalDataSource
) : IWordRepository {

    override suspend fun shuffle(token: Token): List<WordModel> {
        return remote.shuffle(token)
    }
}