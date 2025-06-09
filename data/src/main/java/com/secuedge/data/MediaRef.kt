package com.secuedge.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Reference to captured media on disk.
 */
@Entity
data class MediaRef(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val path: String,
    val synced: Boolean = false
)
