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
            return response.result.map {
                WordModel(
                    id = it._id,
                    word = it.word,
                    defination = it.defination,
                    meaning = it.meaning,
                    example = it.example,
                )
            }
        }

        throw Exception("Unable to get response")
    }

    suspend fun words(token: Token): List<WordModel> {
        val response = api.word(token)
        if (response.success) {
            return response.result.map {
                WordModel(
                    id = it._id,
                    word = it.word,
                    defination = it.defination,
                    meaning = it.meaning,
                    example = it.example,
                )
            }
        }

        throw Exception("Unable to get response")
    }
}