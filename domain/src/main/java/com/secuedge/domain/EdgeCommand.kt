package com.secuedge.domain

/**
 * Commands accepted by the service.
 */
sealed class EdgeCommand {
    object StartCapture : EdgeCommand()
    object StartHotspot : EdgeCommand()
    object SyncCloud : EdgeCommand()
}
