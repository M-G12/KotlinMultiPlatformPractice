package com.example.kk.datasource.network

import io.ktor.client.*

expect class KtorClientFactory() {
    fun build():HttpClient
}