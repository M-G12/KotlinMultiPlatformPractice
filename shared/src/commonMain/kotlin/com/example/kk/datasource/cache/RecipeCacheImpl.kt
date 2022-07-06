package com.example.kk.datasource.cache

import com.example.kk.datasource.domain.model.DatetimeUtil
import com.example.kk.domain.model.Recipe
import com.gharibe.kk.android.datasource.cache.RecipeDatabase
import com.gharibe.kk.android.datasource.cache.RecipeDbQueries

class RecipeCacheImpl(
    recipeDatabase: RecipeDatabase,
    private val datetimeUtil: DatetimeUtil

) : RecipeCache {
    private val queries: RecipeDbQueries = recipeDatabase.recipeDbQueries
    override fun insert(recipe: Recipe) {
        queries.insertRecipe(
            id = recipe.id.toLong(),
            title = recipe.title,
            publisher = recipe.publisher,
            featured_image = recipe.featureImage,
            rating = recipe.rating.toLong(),
            source_url = recipe.sourceUrl,
            ingredients = recipe.ingredients.convertIngredientListToString(),
            date_added = datetimeUtil.toEpochMilliseconds(recipe.dateAdded),
            date_updated = datetimeUtil.toEpochMilliseconds(recipe.dateUpdated)
        )
    }

    override fun insert(recipe: List<Recipe>) {
        for (recipe in recipe) {
            insert(recipe)
        }
    }

    override fun search(query: String, page: Int): List<Recipe> {
        return queries.searchRecipes(
            query = query,
            pageSize = 30L,
            offset = ((page - 1) * 30).toLong()
        ).executeAsList().toRecipeList()
    }

    override fun getAll(page: Int): List<Recipe> {
        TODO("Not yet implemented")
    }

    override fun get(recipeId: Int): Recipe? {
        return try {
            return queries.getRecipeById(id = recipeId.toLong()).executeAsOne().toRecipe()
        } catch (e: Exception) {
            null
        }
    }
}