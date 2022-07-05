package com.example.kk

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}