package com.example.websocketclient

import android.util.Log
import okhttp3.*
import okio.ByteString

/**
 * @author: hsw
 * @date: 2021/12/10
 * @desc:
 */
class WebSocketHandler: WebSocketListener() {
    companion object {
        const val TAG = "WebSocketHandler"
        const val URL = "ws://10.10.5.180:9091/ws"

        private var inst: WebSocketHandler? = null

        fun getInstance(): WebSocketHandler {
            if (inst == null) {
                synchronized(WebSocketHandler::class) {
                    inst = WebSocketHandler()
                }
            }
            return inst!!
        }
    }
    private val client: OkHttpClient = OkHttpClient()

    private var webSocket: WebSocket? = null

    fun connect() {
        Log.d(TAG, "connect")
        val request = Request.Builder()
            .url(URL)
            .build()
        webSocket = client.newWebSocket(request, this)
    }

    fun reConnect() {
        Log.d(TAG, "reConnect")
        webSocket?.let {
            webSocket = client.newWebSocket(it.request(), this)
        }
    }

    fun send(text: String) {
        Log.d(TAG, "send")
        webSocket?.let { it.send(text) }
    }

    fun cancel() {
        Log.d(TAG, "cancel")
        webSocket?.let { it.cancel() }
    }

    fun close() {
        Log.d(TAG, "close")
        webSocket?.let { it.close(1000, null) }
    }

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        Log.d(TAG, "onOpen")
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosed(webSocket, code, reason)
        Log.d(TAG, "onClose")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        Log.d(TAG, "onMessage--$text")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, bytes)
        Log.d(TAG, "onMessage--${String(bytes.toByteArray())}")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
        Log.d(TAG, "onFailure--${t.message}")
    }

}