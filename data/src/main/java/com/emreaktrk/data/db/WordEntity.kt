package com.emreaktrk.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.emreaktrk.core.Mapper
import com.emreaktrk.core.To
import com.emreaktrk.core.model.Word
import com.emreaktrk.core.model.WordModel

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
) : To<WordModel> {

    override fun to(): WordModel {
        return WordModel(
            this.id,
            this.word,
            this.defination,
            this.meaning,
            this.example
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WordEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

class WordModel2WordEntityModel : Mapper<WordModel, WordEntity> {
    override fun map(input: WordModel): WordEntity {
        return WordEntity(
            input.id,
            input.word,
            input.defination,
            input.meaning,
            input.example
        )
    }
}