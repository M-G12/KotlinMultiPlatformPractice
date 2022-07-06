package com.example.kk.datasource.network.interactors.recipe_detail

import com.example.kk.datasource.cache.RecipeCache
import com.example.kk.datasource.network.RecipeService
import com.example.kk.datasource.network.domain.model.util.DataState
import com.example.kk.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipe (
    private val recipeCache: RecipeCache
) {
    fun execute(
        recipeId: Int,
    ): Flow<DataState<Recipe>> = flow {
        try {
            val recipe = recipeCache.get(recipeId)
            emit(DataState.data(recipe))
        }catch (e:Exception){
            emit(DataState.error(e.message?:"Unknown error"))
        }
    }
}