package com.emreaktrk.core.model

typealias Word = String

data class WordModel(
    val id: String,
    val word: Word,
    val definition: String,
)