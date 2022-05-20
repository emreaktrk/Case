package com.emreaktrk.data.user

import com.emreaktrk.data.model.Token
import javax.inject.Inject

class UserRepository @Inject constructor(
    val remote: UserRemoteDataSource,
    val local: UserLocalDataSource
) : IUserRepository {

    override suspend fun authentication(email: String, password: String): Token {
        return remote.authentication(email, password)
    }
}