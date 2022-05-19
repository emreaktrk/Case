package com.emreaktrk.data

class AuthRepository(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) : IAuthRepository {

    override fun login() {

    }

}