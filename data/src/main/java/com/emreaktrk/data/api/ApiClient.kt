package com.emreaktrk.data.api

import com.emreaktrk.data.api.poko.request.UserAuthenticationRequest
import com.emreaktrk.data.api.poko.response.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiClient {

    @POST("user/authentication")
    suspend fun authentication(@Body request: UserAuthenticationRequest): ResultWrapper<TokenResponse>
}