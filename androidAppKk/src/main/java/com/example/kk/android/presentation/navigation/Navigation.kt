package com.example.kk.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kk.android.presentation.recipe_detail.RecipeDetail
import com.example.kk.android.presentation.recipe_list.RecipeList

@Composable
fun Navigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route){
        composable(route= Screen.RecipeList.route){ navBackStackEntry ->
            RecipeList(onSelectRecipe = {recipeId ->
                navController.navigate(
                    Screen.RecipeDetail.route + "/$recipeId"
                )
            })
       }
        composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId"){
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            RecipeDetail(recipeId = navBackStackEntry.arguments?.getInt("recipeId"))
        }
    }
}