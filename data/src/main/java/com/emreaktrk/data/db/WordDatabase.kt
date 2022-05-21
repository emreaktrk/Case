package com.emreaktrk.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        private const val DB_NAME = "WORD"

        @Volatile
        private var instance: WordDatabase? = null

        fun getInstance(context: Context): WordDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): WordDatabase {
            return Room.databaseBuilder(context, WordDatabase::class.java, DB_NAME).build()
        }
    }
}