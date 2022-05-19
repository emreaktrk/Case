package com.emreaktrk.sahibinden.account.sync

import android.app.Service
import android.content.Intent
import android.os.IBinder

class ProfileSyncService : Service() {

    companion object {
        private var sAdapter: ProfileSyncAdapter? = null
    }

    override fun onCreate() {
        super.onCreate()

        sAdapter = ProfileSyncAdapter(
            applicationContext,
            autoInitialize = true,
            allowParallelSyncs = false
        )
    }

    override fun onBind(intent: Intent?): IBinder? {
        return sAdapter!!.syncAdapterBinder
    }
}