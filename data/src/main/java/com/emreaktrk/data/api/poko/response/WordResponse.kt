package com.emreaktrk.data.api.poko.response

import com.emreaktrk.core.model.Word

typealias WordsResponse = List<WordResponse>

data class WordResponse(
    val _id: String,
    val word: Word,
    val definition: String,
    val example: String,
    val focus: Boolean,
    val user: String,
    val notification: Boolean,
    val created_at: String,
    val updated_at: String,
)