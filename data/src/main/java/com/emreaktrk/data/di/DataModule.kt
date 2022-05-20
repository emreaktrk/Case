package com.emreaktrk.data.di

import com.emreaktrk.data.ApiClient
import com.emreaktrk.data.BuildConfig
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@DisableInstallInCheck
object DataModule {

    @Provides
    fun provideApiClient(
        gson: Gson,
    ): ApiClient {
        val http = OkHttpClient
            .Builder()
            .build()

        return Retrofit
            .Builder()
            .client(http)
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiClient::class.java)
    }
}