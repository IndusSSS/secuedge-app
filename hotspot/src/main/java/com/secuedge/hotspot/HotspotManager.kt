package com.secuedge.hotspot

import android.content.Context
import android.net.TetheringManager

/**
 * Manages hotspot operations. Device-owner privileges required for full use.
 */
class HotspotManager(private val context: Context) {

    fun requestLocalOnlyHotspot() {
        // TODO requires privileged API for device-owner mode
        val manager = context.getSystemService(TetheringManager::class.java)
        manager?.startTethering(TetheringManager.TETHERING_WIFI, true, {})
    }
}
