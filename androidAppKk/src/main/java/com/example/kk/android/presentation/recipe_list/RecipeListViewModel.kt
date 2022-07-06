package com.example.kk.android.presentation.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kk.datasource.network.RecipeService
import com.example.kk.datasource.network.interactors.recipe_list.SearchRecipes
import com.example.kk.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.temporal.TemporalQuery
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchRecipes: SearchRecipes,

    ) : ViewModel() {
    val products: MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    fun loadRecipes(query: String) {
        searchRecipes.execute(
            page = 2,
            query = query
        ).onEach { recipes ->
            recipes.data?.let {
                products.value=it
            }
        }.launchIn(viewModelScope)
    }
}