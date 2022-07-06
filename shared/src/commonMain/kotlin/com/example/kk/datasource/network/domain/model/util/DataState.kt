package com.example.kk.datasource.network.domain.model.util

import com.example.kk.domain.model.Recipe

data class DataState <T> (
    val message: String?= null,
    val data: T? = null,
    val isLoading: Boolean = false
){
    companion object{
        fun <T> error(
            message: String,
        ):DataState<T>{
            return DataState(
                message
            )
        }
        fun <T> data(
            data: T?= null
        ):DataState<T>{
            return DataState(
                data = data
            )
        }
        fun loading() = true
    }
}