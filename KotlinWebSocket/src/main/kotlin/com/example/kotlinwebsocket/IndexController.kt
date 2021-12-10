package com.example.kotlinwebsocket

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hsw")
open class IndexController {

    @RequestMapping("test")
    fun test(): String {
        return "tttttt"
    }
}