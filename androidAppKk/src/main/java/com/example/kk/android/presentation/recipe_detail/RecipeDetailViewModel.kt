package com.example.kk.android.presentation.recipe_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kk.datasource.domain.model.DatetimeUtil
import com.example.kk.datasource.network.RecipeService
import com.example.kk.domain.model.Recipe

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val recipeService: RecipeService,
): ViewModel() {

    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    init {
        try {
            savedStateHandle.get<Int>("recipeId")?.let { recipeId ->
                viewModelScope.launch{
                    recipe.value = recipeService.get(recipeId)
                    println("KtorTest: ${recipe.value?.title}")
                    println("KtorTest: ${recipe.value?.ingredients}")
                }
            }
        }catch (e: Exception){
            // will throw exception if arg is not there for whatever reason.
            // we don't need to do anything because it will already show a composable saying "Unable to get the details of this recipe..."
        }
    }
}