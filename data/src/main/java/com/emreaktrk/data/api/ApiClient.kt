package com.emreaktrk.data.api

import com.emreaktrk.core.model.Token
import com.emreaktrk.data.api.poko.request.UserAuthenticationRequest
import com.emreaktrk.data.api.poko.response.TokenResponse
import com.emreaktrk.data.api.poko.response.WordsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiClient {

    @POST("user/authentication")
    suspend fun authentication(
        @Body request: UserAuthenticationRequest
    ): ResultWrapper<TokenResponse>

    @GET("word/shuffle")
    suspend fun shuffle(
        @Header("token") token: Token
    ): ResultWrapper<WordsResponse>

    @GET("word/myword/0")
    suspend fun word(
        @Header("token") token: Token,
    ): ResultWrapper<WordsResponse>
}