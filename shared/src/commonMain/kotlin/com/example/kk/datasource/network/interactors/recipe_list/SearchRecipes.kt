package com.example.kk.datasource.network.interactors.recipe_list

import com.example.kk.datasource.cache.RecipeCache
import com.example.kk.datasource.network.RecipeService
import com.example.kk.datasource.network.domain.model.util.DataState
import com.example.kk.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
    private val recipeCache: RecipeCache
) {
    fun execute(
        page: Int,
        query: String,
    ): Flow<DataState<List<Recipe>>> = flow {
        try {
            val recipe = recipeService.search(
                page, query
            )
            recipeCache.insert(recipe)
            val cacheResult =
                recipeCache.search(
                    query = query,
                    page = page
                )
            emit(DataState.data(cacheResult))
        } catch (e: Exception) {
            emit(DataState.error(message = e.message ?: "Unknown"))
        }
    }
}