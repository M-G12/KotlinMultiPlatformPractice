package com.example.kk.datasource.cache

import com.example.kk.datasource.domain.model.DatetimeUtil
import com.example.kk.domain.model.Recipe
import com.gharibe.kk.android.datasource.cache.RecipeDatabase
import com.gharibe.kk.android.datasource.cache.Recipe_Entity
import com.squareup.sqldelight.db.SqlDriver

class RecipeDataBaseFactory(
    private val driverFactory: DriverFactory
) {
    fun createDatabase(): RecipeDatabase{
        return RecipeDatabase(driverFactory.createDriver())
    }
}

expect class DriverFactory{
    fun createDriver():SqlDriver
}

fun Recipe_Entity.toRecipe():Recipe{
    val datetimeUtil = DatetimeUtil()
    return Recipe(
        id = id.toInt(),
        title = title,
        publisher = publisher,
        featureImage = featured_image,
        sourceUrl = source_url,
        ingredients = ingredients.convertIngredientToList(),
        rating = rating.toInt(),
        dateUpdated = datetimeUtil.toLocalDate(date_updated),
        dateAdded = datetimeUtil.toLocalDate(date_added)
    )
}

fun List<Recipe_Entity>.toRecipeList():List<Recipe>{
    return map{
        it.toRecipe()
    }
}

fun List<String>.convertIngredientListToString(): String{
    val ingredientString = StringBuilder()
    for (ingredient in this){
        ingredientString.append("${ingredient},")
    }
    return ingredientString.toString()
}

fun String.convertIngredientToList():List<String>{
    val list:ArrayList<String> = ArrayList()
    for (ingredient in split(",")){
        list.add(ingredient)
    }
    return list
}