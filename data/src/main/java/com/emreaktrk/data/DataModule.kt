package com.emreaktrk.data

import com.emreaktrk.data.api.ApiClient
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideApiClient(
        gson: Gson,
    ): ApiClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val http = OkHttpClient
            .Builder()
            .addInterceptor(logging)
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