package com.secuedge.core

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.secuedge.network.ApiClient

/**
 * Periodic worker to sync logs and media.
 */
class CloudSyncWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        // TODO upload unsynced items
        ApiClient.retrofit
        return Result.success()
    }
}
