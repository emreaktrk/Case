package com.emreaktrk.sahibinden.account

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.emreaktrk.sahibinden.account.AccountAuthenticator

class AuthenticatorService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        val authenticator = AccountAuthenticator(this)
        return authenticator.iBinder
    }
}