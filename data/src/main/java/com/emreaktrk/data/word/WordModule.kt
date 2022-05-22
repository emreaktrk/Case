package com.emreaktrk.data.word

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WordModule {

    @Binds
    abstract fun bindRepository(repository: WordRepository): IWordRepository
}