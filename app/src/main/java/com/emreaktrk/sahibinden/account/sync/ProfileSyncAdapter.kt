package com.emreaktrk.sahibinden.account.sync

import android.accounts.Account
import android.content.AbstractThreadedSyncAdapter
import android.content.ContentProviderClient
import android.content.Context
import android.content.SyncResult
import android.os.Bundle

class ProfileSyncAdapter(context: Context, autoInitialize: Boolean, allowParallelSyncs: Boolean) :
    AbstractThreadedSyncAdapter(context, autoInitialize, allowParallelSyncs) {

    override fun onPerformSync(
        account: Account,
        bundle: Bundle,
        s: String,
        contentProviderClient: ContentProviderClient,
        syncResult: SyncResult
    ) {
        // TODO Sync account
    }
}