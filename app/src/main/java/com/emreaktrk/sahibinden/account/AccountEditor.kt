package com.emreaktrk.sahibinden.account

import android.accounts.Account
import android.accounts.AccountManager
import android.content.ContentResolver
import android.content.Context
import android.os.Bundle
import com.emreaktrk.sahibinden.account.sync.ProfileContract
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class AccountEditor(private val context: Context) {

    companion object {
        private val GSON: Gson by lazy {
            GsonBuilder()
                .disableHtmlEscaping()
                .create()
        }
    }

    val has: Boolean
        get() = AccountManager
            .get(context)
            .getAccountsByType(AccountContract.ACCOUNT_TYPE)
            .isEmpty()
            .not()

    val token: String?
        get() {
            val account = AccountManager
                .get(context)
                .getAccountsByType(AccountContract.ACCOUNT_TYPE)[0]

            return try {
                "Bearer ${
                    AccountManager
                        .get(context)
                        .getAuthToken(account, AccountContract.FULL_ACCESS, null, null, null, null)
                        .result
                        .getString(AccountManager.KEY_AUTHTOKEN)
                }"
            } catch (e: Exception) {
                null
            }
        }

    var me: Me
        set(value) {
            val account = AccountManager
                .get(context)
                .getAccountsByType(AccountContract.ACCOUNT_TYPE)[0]

            AccountManager
                .get(context)
                .setUserData(account, AccountManager.KEY_USERDATA, GSON.toJson(value))
        }
        get() {
            val account = AccountManager
                .get(context)
                .getAccountsByType(AccountContract.ACCOUNT_TYPE)[0]

            return GSON.fromJson(
                AccountManager.get(context).getUserData(
                    account,
                    AccountManager.KEY_USERDATA
                ), Me::class.java
            )
        }

    fun login(
        token: String,
        me: Me
    ) {
        val account = Account(me.email, AccountContract.ACCOUNT_TYPE)

        AccountManager
            .get(context)
            .addAccountExplicitly(account, null, null)

        AccountManager
            .get(context)
            .setAuthToken(account, AccountContract.FULL_ACCESS, token)

        AccountManager
            .get(context)
            .setUserData(account, AccountManager.KEY_USERDATA, GSON.toJson(me))
    }

    fun sync() {
        val account = AccountManager
            .get(context)
            .getAccountsByType(AccountContract.ACCOUNT_TYPE)[0]

        ContentResolver.requestSync(account, ProfileContract.AUTHORITY, Bundle.EMPTY)
    }

    fun logout(callback: (result: Boolean) -> Unit) {
        val accounts = AccountManager
            .get(context)
            .getAccountsByType(AccountContract.ACCOUNT_TYPE)
        if (accounts.isEmpty()) {
            return
        }

        val account = accounts[0]
        AccountManager
            .get(context)
            .removeAccountExplicitly(account)

        callback(true)
    }
}