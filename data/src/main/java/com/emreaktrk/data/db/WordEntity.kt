package com.emreaktrk.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.emreaktrk.core.model.Word

@Entity(
    tableName = "words",
    indices = [Index("id")]
)
data class WordEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "word") val word: Word,
    @ColumnInfo(name = "defination") val defination: String,
    @ColumnInfo(name = "meaning") val meaning: String,
    @ColumnInfo(name = "example") val example: String,
)