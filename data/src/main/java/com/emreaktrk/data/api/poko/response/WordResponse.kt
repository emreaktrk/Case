package com.emreaktrk.data.api.poko.response

import com.emreaktrk.core.Mapper
import com.emreaktrk.core.model.Word
import com.emreaktrk.core.model.WordModel

typealias WordsResponse = List<WordResponse>

data class WordResponse(
    val _id: String,
    val word: Word,
    val defination: String,
    val meaning: String,
    val example: String,
    val focus: Boolean,
    val user: String,
    val notification: Boolean,
    val created_at: String,
    val updated_at: String,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WordResponse

        if (_id != other._id) return false

        return true
    }

    override fun hashCode(): Int {
        return _id.hashCode()
    }
}

class WordResponse2WordModelMapper : Mapper<WordResponse, WordModel> {

    override fun map(input: WordResponse): WordModel {
        return WordModel(
            id = input._id,
            word = input.word,
            defination = input.defination,
            meaning = input.meaning,
            example = input.example,
        )
    }
}