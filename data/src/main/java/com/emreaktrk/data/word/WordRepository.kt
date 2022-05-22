package com.emreaktrk.data.word

import com.emreaktrk.core.model.Token
import com.emreaktrk.core.model.WordModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WordRepository @Inject constructor(
    private val remote: WordRemoteDataSource,
    private val local: WordLocalDataSource
) : IWordRepository {

    override suspend fun shuffle(token: Token): List<WordModel> {
        return remote.shuffle(token).also {
            local.bulkInsert(it)
        }
    }

    override suspend fun shuffleAsFlow(token: Token): Flow<List<WordModel>> {
        return flow {
            val localData = local.read()
            if (localData.isNotEmpty()) {
                emit(localData)
            }

            val remoteData = remote.shuffle(token).also {
                local.bulkInsert(it)
            }
            emit(remoteData)
        }
    }

    override suspend fun word(id: String): WordModel {
        return local.word(id)
    }
}