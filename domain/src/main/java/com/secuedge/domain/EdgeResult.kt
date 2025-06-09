package com.secuedge.domain

/**
 * Results emitted by use cases.
 */
sealed class EdgeResult {
    object Success : EdgeResult()
    data class Error(val throwable: Throwable) : EdgeResult()
}
