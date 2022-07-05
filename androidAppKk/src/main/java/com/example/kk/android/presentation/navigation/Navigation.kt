package com.example.kk.android.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kk.android.presentation.recipe_detail.RecipeDetail
import com.example.kk.android.presentation.recipe_detail.RecipeDetailViewModel
import com.example.kk.android.presentation.recipe_list.RecipeList
import com.example.kk.android.presentation.recipe_list.RecipeListViewModel

@Composable
fun Navigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route){
        composable(route= Screen.RecipeList.route){ backStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, backStackEntry)
            val viewMode: RecipeListViewModel = viewModel(key = "RecipeListViewModel", factory = factory)
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
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewMode: RecipeDetailViewModel = viewModel(key = "RecipeDetailViewModel", factory = factory)
            RecipeDetail(viewMode.recipeId.value)
        }
    }
}