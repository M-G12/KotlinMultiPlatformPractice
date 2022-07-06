package com.example.kk.datasource.cache

import com.example.kk.domain.model.Recipe

interface RecipeCache {
    fun insert(recipe: Recipe)
    fun insert(recipe: List<Recipe>)
    fun search(query: String, page:Int): List<Recipe>
    fun getAll(page:Int):List<Recipe>
    @Throws(NullPointerException::class)
    fun get(recipeId:Int): Recipe?
}