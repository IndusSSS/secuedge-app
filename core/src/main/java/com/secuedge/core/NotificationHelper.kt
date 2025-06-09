package com.secuedge.core

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

/**
 * Utility to create notification channels.
 */
object NotificationHelper {
    private const val CHANNEL_ID = "edge_service"

    fun ensureChannel(context: Context): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_LOW)
            manager.createNotificationChannel(channel)
        }
        return CHANNEL_ID
    }
}
