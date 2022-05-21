package com.emreaktrk.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM words")
    suspend fun getWords(): List<WordEntity>

    @Insert
    suspend fun insertWord(entity: WordEntity): Long

    @Query("DELETE FROM words")
    fun deleteAll()
}