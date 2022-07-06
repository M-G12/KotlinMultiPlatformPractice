package com.example.kk.android.di

import com.example.kk.datasource.cache.RecipeCache
import com.example.kk.datasource.network.RecipeService
import com.example.kk.datasource.network.interactors.recipe_detail.GetRecipe
import com.example.kk.datasource.network.interactors.recipe_list.SearchRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideSearchRecipe(
        recipeService: RecipeService,
        recipeCache: RecipeCache
    ) : SearchRecipes{
        return SearchRecipes(recipeService= recipeService, recipeCache = recipeCache)
    }
    @Singleton
    @Provides
    fun provideGetRecipe(
        recipeCache: RecipeCache
    ):GetRecipe{
        return GetRecipe(recipeCache = recipeCache)
    }
}