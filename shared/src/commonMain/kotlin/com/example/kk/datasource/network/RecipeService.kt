package com.example.kk.datasource.network

import com.example.kk.domain.model.Recipe

interface RecipeService {
    suspend fun search(
        page : Int,
        query:String
    ): List<Recipe>

    suspend fun get(
        id: Int,
    ):Recipe
}