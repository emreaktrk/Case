package com.emreaktrk.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.emreaktrk.data.AppDataStore.Keys.USER_ALREADY_LOGGED_IN
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    object Keys {
        const val FILE_NAME = "app.preferences_pb"

        val USER_ALREADY_LOGGED_IN = booleanPreferencesKey("userAlreadyLoggedIn")
    }

    suspend fun setHasAlreadyLoggedIn(value: Boolean) {
        dataStore.edit {
            it[USER_ALREADY_LOGGED_IN] = value
        }
    }

    suspend fun isUserAlreadyLoggedIn(): Boolean {
        return dataStore.data.map {
            return@map it[USER_ALREADY_LOGGED_IN] ?: false
        }.first()
    }
}