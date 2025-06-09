package com.secuedge.tests

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.secuedge.data.EdgeDao
import com.secuedge.data.EdgeDatabase
import com.secuedge.data.EdgeLog
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Simple Room insert/retrieve test.
 */
@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    @Test
    fun insertAndRead() = runBlocking {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        val db = Room.inMemoryDatabaseBuilder(context, EdgeDatabase::class.java).build()
        val dao: EdgeDao = db.edgeDao()
        dao.insertLog(EdgeLog(message = "hello"))
        val logs = dao.getLogs().first()
        assertEquals(1, logs.size)
        assertEquals("hello", logs[0].message)
    }
}
