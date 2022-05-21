package com.emreaktrk.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM words")
    suspend fun getWords(): List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(entity: WordEntity): Long

    @Query("SELECT * FROM words ORDER BY RANDOM() LIMIT 1")
    fun random(): WordEntity

    @Query("DELETE FROM words")
    suspend fun deleteAll()
}