package com.emreaktrk.data.word

import com.emreaktrk.core.model.WordModel
import com.emreaktrk.data.IDataSource
import com.emreaktrk.data.db.WordDao
import com.emreaktrk.data.db.WordEntity
import javax.inject.Inject

class WordLocalDataSource @Inject constructor(
    private val dao: WordDao
) : IDataSource {

    suspend fun bulkInsert(list: List<WordModel>) {
        dao.deleteAll()
        list.map {
            WordEntity(
                it.id,
                it.word,
                it.defination,
                it.meaning,
                it.example
            )
        }.forEach { dao.insertWord(it) }
    }

    suspend fun read(): List<WordModel> {
        return dao.getWords().map {
            WordModel(
                it.id,
                it.word,
                it.defination,
                it.meaning,
                it.example
            )
        }
    }

    suspend fun word(id: String): WordModel {
        return dao.getWord(id).run {
            WordModel(
                this.id,
                this.word,
                this.defination,
                this.meaning,
                this.example
            )
        }
    }

    fun random(): WordModel {
        return dao.random().run {
            WordModel(
                this.id,
                this.word,
                this.defination,
                this.meaning,
                this.example
            )
        }
    }
}