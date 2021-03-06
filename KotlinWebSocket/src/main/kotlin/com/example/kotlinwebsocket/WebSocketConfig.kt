package com.example.kotlinwebsocket

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
open class WebSocketConfig: WebSocketConfigurer {

    private fun getSocketHandler(): WebSocketHandler {
        return SocketController()
    }

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(getSocketHandler(), "/ws").setAllowedOrigins("*")
    }
}