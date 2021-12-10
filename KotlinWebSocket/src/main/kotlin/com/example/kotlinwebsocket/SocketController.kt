package com.example.kotlinwebsocket

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println
import org.springframework.stereotype.Component
import org.springframework.web.socket.*

@Component
open class SocketController: WebSocketHandler {

    init {
        println("SocketController init")
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        println("afterConnectionEstablished")
    }

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        println("handleMessage $message")
        session.sendMessage(TextMessage("RESPONSE_MESSAGE"))
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        println("handleMessage")
    }

    override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
        println("afterConnectionClosed")
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }
}