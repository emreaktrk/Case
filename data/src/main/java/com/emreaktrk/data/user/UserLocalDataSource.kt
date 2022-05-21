package com.emreaktrk.data.user

import com.emreaktrk.data.AppDataStore
import com.emreaktrk.data.IDataSource
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val appDataStore: AppDataStore
) : IDataSource {

    suspend fun setHasAlreadyLoggedIn(value: Boolean) = appDataStore.setHasAlreadyLoggedIn(value)

    suspend fun isUserAlreadyLoggedIn(): Boolean = appDataStore.isUserAlreadyLoggedIn()
}