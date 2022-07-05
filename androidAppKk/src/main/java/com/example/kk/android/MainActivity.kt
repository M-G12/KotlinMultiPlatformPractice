package com.example.kk.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.kk.android.presentation.navigation.Navigation
import com.example.kk.datasource.network.KtorClientFactory
import com.example.kk.datasource.network.RecipeServiceImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
const val BASE_URL = "https://food2fork.ca/api/recipe"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ktorClient = KtorClientFactory().build()
        CoroutineScope(IO).launch {
            val recipeService = RecipeServiceImpl(
                httpClient = ktorClient,
                baseUrl = BASE_URL
            )
            val recipeId = 600
            val recipe = recipeService.get(recipeId)
            println("KtorTest: ${recipe.title}")
            println("KtorTest: ${recipe.ingredients}")
            println("KtorTest: ${recipe.publisher}")
            println("KtorTest: ${recipe.rating}")
        }

        setContent {
            Navigation()
        }
    }
}
