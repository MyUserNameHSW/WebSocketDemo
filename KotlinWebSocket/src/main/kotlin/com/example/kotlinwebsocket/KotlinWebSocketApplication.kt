package com.example.kotlinwebsocket

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinWebSocketApplication

fun main(args: Array<String>) {
    runApplication<KotlinWebSocketApplication>(*args)
    println("start application")
}
