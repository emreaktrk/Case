package com.emreaktrk.data

import android.content.Context
import com.emreaktrk.data.api.ApiClient
import com.emreaktrk.data.db.WordDao
import com.emreaktrk.data.db.WordDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
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

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): WordDatabase {
        return WordDatabase.getInstance(context)
    }

    @Provides
    fun provideWordDao(
        database: WordDatabase
    ): WordDao {
        return database.wordDao()
    }
}