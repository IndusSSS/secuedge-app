package com.secuedge.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Room database for logs and media references.
 */
@Database(entities = [EdgeLog::class, MediaRef::class], version = 1)
abstract class EdgeDatabase : RoomDatabase() {
    abstract fun edgeDao(): EdgeDao

    companion object {
        fun create(context: Context): EdgeDatabase =
            Room.databaseBuilder(context, EdgeDatabase::class.java, "edge.db").build()
    }
}
