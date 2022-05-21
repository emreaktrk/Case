package com.emreaktrk.data.user

import com.emreaktrk.core.model.Token
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remote: UserRemoteDataSource,
    private val local: UserLocalDataSource
) : IUserRepository {

    override suspend fun authentication(email: String, password: String): Token {
        return remote.authentication(email, password)
    }
}