package com.emreaktrk.core.model

typealias Word = String

data class WordModel(
    val id: String,
    val word: Word,
    val defination: String,
    val meaning: String,
    val example: String,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WordModel

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}