package com.secuedge.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Log entry stored on device.
 */
@Entity
data class EdgeLog(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val message: String,
    val synced: Boolean = false
)
