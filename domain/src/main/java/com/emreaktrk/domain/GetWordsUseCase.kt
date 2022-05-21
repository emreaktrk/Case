package com.emreaktrk.domain

import com.emreaktrk.core.model.Token
import com.emreaktrk.core.model.WordModel
import com.emreaktrk.data.word.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWordsUseCase @Inject constructor(
    private val repo: WordRepository,
) : UseCase<Token?, List<WordModel>>() {
    override fun onInvoke(input: Token?): Flow<List<WordModel>> {
        return flow {
            if (input.isNullOrEmpty()) {
                throw IllegalStateException("Need authentication")
            }

            val words = repo.shuffle(input)
            emit(words)
        }
    }
}