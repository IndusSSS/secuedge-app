package com.secuedge.core

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.view.Surface
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import kotlinx.coroutines.tasks.await

/**
 * Manages camera capture using CameraX.
 */
class CaptureManager(private val context: Context) {

    suspend fun start(surface: Surface) {
        if (!hasPermissions()) return
        val provider = ProcessCameraProvider.getInstance(context).await()
        val preview = Preview.Builder().build().apply { setSurfaceProvider { surface } }
        provider.bindToLifecycle(context as? androidx.lifecycle.LifecycleOwner ?: return,
            CameraSelector.DEFAULT_BACK_CAMERA, preview)
    }

    private fun hasPermissions(): Boolean {
        val camera = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
        return camera == PackageManager.PERMISSION_GRANTED
    }
}
