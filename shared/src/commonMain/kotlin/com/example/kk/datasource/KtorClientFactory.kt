package com.example.kk.datasource

import com.example.kk.datasource.domain.model.DatetimeUtil
import com.example.kk.datasource.network.model.RecipeDto
import com.example.kk.domain.model.Recipe
import io.ktor.client.*

expect class KtorClientFactory() {
    fun build(): HttpClient
}

fun RecipeDto.toRecipe(): Recipe {
    val datetimeUtil = DatetimeUtil()
    return Recipe(
        id = pk,
        title = title,
        featureImage = featuredImage,
        rating = rating,
        publisher = publisher,
        sourceUrl = sourceUrl,
        ingredients = ingredients,
        dateAdded = datetimeUtil.toLocalDate(longDateAdded.toDouble()),
        dateUpdated = datetimeUtil.toLocalDate(longDateUpdated.toDouble())
    )
}
fun List<RecipeDto>.toRecipeList():List<Recipe>{
    return map { it.toRecipe() }
}