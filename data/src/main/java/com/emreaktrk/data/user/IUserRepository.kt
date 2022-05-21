package com.emreaktrk.data.user

import com.emreaktrk.core.model.Token

interface IUserRepository {
    suspend fun authentication(email: String, password: String): Token
}