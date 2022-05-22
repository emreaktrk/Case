package com.emreaktrk.data.word

import com.emreaktrk.core.model.WordModel
import com.emreaktrk.data.IDataSource
import com.emreaktrk.data.db.WordDao
import com.emreaktrk.data.db.WordModel2WordEntityModel
import javax.inject.Inject

class WordLocalDataSource @Inject constructor(
    private val dao: WordDao
) : IDataSource {

    suspend fun bulkInsert(list: List<WordModel>) {
        dao.deleteAll()

        val mapper = WordModel2WordEntityModel()
        list.map { mapper.map(it) }.forEach { dao.insertWord(it) }
    }

    suspend fun read(): List<WordModel> {
        return dao.getWords().map { it.to() }
    }

    suspend fun word(id: String): WordModel {
        return dao.getWord(id).to()
    }

    fun random(): WordModel {
        return dao.random().run { this.to() }
    }
}