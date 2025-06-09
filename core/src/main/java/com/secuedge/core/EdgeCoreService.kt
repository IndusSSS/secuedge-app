package com.secuedge.core

import android.Manifest
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.IBinder
import android.view.Surface
import android.view.SurfaceTexture
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleService
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.secuedge.domain.EdgeCommand
import java.util.concurrent.TimeUnit

/**
 * Foreground service handling edge capture and hotspot commands.
 */
class EdgeCoreService : LifecycleService() {

    private lateinit var captureManager: CaptureManager
    private lateinit var hotspotManager: com.secuedge.hotspot.HotspotManager

    override fun onCreate() {
        super.onCreate()
        captureManager = CaptureManager(this)
        hotspotManager = com.secuedge.hotspot.HotspotManager(this)
        startForegroundService()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.getStringExtra("cmd")) {
            EdgeCommand.StartCapture::class.java.simpleName -> launchCapture()
            EdgeCommand.StartHotspot::class.java.simpleName -> hotspotManager.requestLocalOnlyHotspot()
            EdgeCommand.SyncCloud::class.java.simpleName -> enqueueSync()
        }
        return Service.START_STICKY
    }

    private fun startForegroundService() {
        val channelId = NotificationHelper.ensureChannel(this)
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("SecuEdge Running")
            .setSmallIcon(android.R.drawable.ic_menu_camera)
            .setOngoing(true)
            .build()
        startForeground(1, notification)
    }

    private fun launchCapture() {
        if (hasPermissions()) {
            val texture = SurfaceTexture(0)
            texture.setDefaultBufferSize(640, 480)
            val surface = Surface(texture)
            lifecycleScope.launchWhenStarted {
                captureManager.start(surface)
            }
        }
    }

    private fun enqueueSync() {
        val request = PeriodicWorkRequestBuilder<CloudSyncWorker>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(request)
    }

    private fun hasPermissions(): Boolean {
        val perms = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.POST_NOTIFICATIONS
        )
        return perms.all { ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED }
    }

    override fun onBind(intent: Intent): IBinder? = super.onBind(intent)
}
