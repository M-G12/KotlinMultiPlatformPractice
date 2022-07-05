package com.example.kk.android.presentation.recipe_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.kk.domain.model.Recipe

@Composable
fun RecipeDetail(
    recipe: Recipe?,
){
    if (recipe == null) {
        Text(text = "ERROR")
    } else{
        Column() {


        Text(text = "RecipeDetailScreen: ${recipe.id}")
        Divider()
        Text(text = "RecipeDetailScreen: ${recipe.title}")
        Divider()
        Text(text = "RecipeDetailScreen: ${recipe.publisher}")
        Divider()
        }

    }
}