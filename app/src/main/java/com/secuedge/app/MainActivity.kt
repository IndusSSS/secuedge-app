package com.secuedge.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.secuedge.core.EdgeCoreService
import com.secuedge.core.NotificationHelper
import com.secuedge.data.EdgeDatabase
import com.secuedge.domain.EdgeCommand
import kotlinx.coroutines.launch

/**
 * Main screen with basic actions.
 */
class MainActivity : ComponentActivity() {

    private val db by lazy { EdgeDatabase.create(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreen() }
    }

    @Composable
    private fun MainScreen() {
        val logs by db.edgeDao().getLogs().collectAsState(initial = emptyList())
        Column {
            Button(onClick = { sendCommand(EdgeCommand.StartCapture) }) {
                Text("Start Capture")
            }
            Button(onClick = { sendCommand(EdgeCommand.StartHotspot) }) {
                Text("Start Hotspot")
            }
            Button(onClick = { sendCommand(EdgeCommand.SyncCloud) }) {
                Text("Sync Now")
            }
            Text("Logs: ${'$'}{logs.size}")
        }
    }

    private fun sendCommand(cmd: EdgeCommand) {
        lifecycleScope.launch {
            val intent = android.content.Intent(this@MainActivity, EdgeCoreService::class.java)
            intent.putExtra("cmd", cmd::class.java.simpleName)
            startService(intent)
        }
    }
}
