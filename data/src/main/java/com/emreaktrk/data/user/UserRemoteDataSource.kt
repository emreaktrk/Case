package com.emreaktrk.data.user

import com.emreaktrk.data.IDataSource
import com.emreaktrk.data.api.ApiClient
import com.emreaktrk.data.api.poko.request.UserAuthenticationRequest
import com.emreaktrk.data.model.Token
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    val api: ApiClient,
) : IDataSource {
    suspend fun authentication(email: String, password: String): Token {
        val request = UserAuthenticationRequest(email, password)
        val response = api.authentication(request)
        if (response.success) {
            return response.result.token
        }

        throw Exception("Unable to get response")
    }
}