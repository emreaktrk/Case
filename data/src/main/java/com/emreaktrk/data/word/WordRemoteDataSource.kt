package com.emreaktrk.data.word

import com.emreaktrk.core.model.Token
import com.emreaktrk.core.model.WordModel
import com.emreaktrk.data.IDataSource
import com.emreaktrk.data.api.ApiClient
import com.emreaktrk.data.api.AuthRequired
import com.emreaktrk.data.api.poko.response.WordResponse2WordModelMapper
import javax.inject.Inject

class WordRemoteDataSource @Inject constructor(
    @AuthRequired val api: ApiClient,
) : IDataSource {
    suspend fun shuffle(token: Token): List<WordModel> {
        val response = api.shuffle(token)
        if (response.success) {
            val mapper = WordResponse2WordModelMapper()
            return response.result.map { mapper.map(it) }
        }

        throw Exception("Unable to get response")
    }

    suspend fun words(token: Token): List<WordModel> {
        val response = api.word(token)
        if (response.success) {
            val mapper = WordResponse2WordModelMapper()
            return response.result.map { mapper.map(it) }
        }

        throw Exception("Unable to get response")
    }
}