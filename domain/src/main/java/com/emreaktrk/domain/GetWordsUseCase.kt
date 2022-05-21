package com.emreaktrk.domain

import com.emreaktrk.core.model.WordModel
import com.emreaktrk.data.word.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWordsUseCase @Inject constructor(
    private val repo: WordRepository,
) : UseCase<String?, List<WordModel>>() {
    override fun onInvoke(token: String?): Flow<List<WordModel>> {
        return flow {
            if (token.isNullOrEmpty()) {
                throw IllegalStateException("Need authentication")
            }

            val words = repo.shuffle(token)
            emit(words)
        }
    }

}