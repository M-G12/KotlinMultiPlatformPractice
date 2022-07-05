package com.example.kk.android.presentation.navigation

sealed class Screen(val route: String) {
    object RecipeList: Screen(route = "RecipeList")
    object RecipeDetail: Screen(route = "RecipeDetail")
}