package com.emreaktrk.sahibinden

import android.content.Context
import com.emreaktrk.sahibinden.account.AccountEditor
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
object AppModule {

    @Provides
    fun provideAccountEditor(@ApplicationContext context: Context): AccountEditor {
        return AccountEditor(context)
    }
}