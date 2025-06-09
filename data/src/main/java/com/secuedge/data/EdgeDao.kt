package com.secuedge.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * DAO for edge database.
 */
@Dao
interface EdgeDao {
    @Insert
    suspend fun insertLog(log: EdgeLog)

    @Query("SELECT * FROM EdgeLog")
    fun getLogs(): Flow<List<EdgeLog>>
}
