package com.emreaktrk.domain

import com.emreaktrk.core.model.WordModel
import com.emreaktrk.data.word.IWordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWordUseCase @Inject constructor(
    private val repo: IWordRepository,
) : UseCase<String, WordModel>() {
    override suspend fun onInvoke(input: String): Flow<WordModel> {
        return flow {
            val word = repo.word(input)
            emit(word)
        }
    }
}