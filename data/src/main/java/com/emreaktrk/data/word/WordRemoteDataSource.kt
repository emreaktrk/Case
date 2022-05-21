package com.emreaktrk.data.word

import com.emreaktrk.core.model.Token
import com.emreaktrk.core.model.WordModel
import com.emreaktrk.data.IDataSource
import com.emreaktrk.data.api.ApiClient
import javax.inject.Inject

class WordRemoteDataSource @Inject constructor(
    val api: ApiClient,
) : IDataSource {
    suspend fun shuffle(token: Token): List<WordModel> {
        val response = api.shuffle(token)
        if (response.success) {
            return response.result.map { WordModel(it._id, it.word, it.definition) }
        }

        throw Exception("Unable to get response")
    }
}