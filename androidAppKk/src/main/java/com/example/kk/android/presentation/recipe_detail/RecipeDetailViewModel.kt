package com.example.kk.android.presentation.recipe_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kk.datasource.domain.model.DatetimeUtil
import com.example.kk.datasource.network.RecipeService
import com.example.kk.datasource.network.interactors.recipe_detail.GetRecipe
import com.example.kk.domain.model.Recipe

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getRecipe: GetRecipe,
): ViewModel() {

    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    init {
        savedStateHandle.get<Int>("recipeId")?.let { recipeId ->
            viewModelScope.launch {
            getRecipe(recipeId)
            }
        }
    }

    fun getRecipe(recipeId: Int) {
        getRecipe.execute(recipeId).onEach { Data ->
            Data.data.let {
                recipe.value = it
            }
        }.launchIn(viewModelScope)
    }
}