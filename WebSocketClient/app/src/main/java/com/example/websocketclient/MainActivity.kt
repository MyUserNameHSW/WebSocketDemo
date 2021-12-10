package com.example.websocketclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.websocketclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val webSocketHandler = WebSocketHandler.getInstance()
        binding.btnConn.setOnClickListener {
            webSocketHandler.connect()
        }
        binding.btnReonn.setOnClickListener {
            webSocketHandler.reConnect()
        }
        binding.btnCancel.setOnClickListener {
            webSocketHandler.cancel()
        }
        binding.btnClose.setOnClickListener {
            webSocketHandler.close()
        }
        binding.btnSend.setOnClickListener {
            webSocketHandler.send("xxxxxx")
        }
    }
}