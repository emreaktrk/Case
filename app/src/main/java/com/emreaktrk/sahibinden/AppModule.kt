package com.emreaktrk.sahibinden

import android.content.Context
import com.emreaktrk.sahibinden.account.AccountEditor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAccountEditor(@ApplicationContext context: Context): AccountEditor {
        return AccountEditor(context)
    }
}