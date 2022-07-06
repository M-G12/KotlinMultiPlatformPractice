package com.example.kk.android.di

import android.content.Context
import com.example.kk.android.BaseApplication
import com.example.kk.datasource.cache.DriverFactory
import com.example.kk.datasource.cache.RecipeCache
import com.example.kk.datasource.cache.RecipeCacheImpl
import com.example.kk.datasource.cache.RecipeDataBaseFactory
import com.example.kk.datasource.domain.model.DatetimeUtil
import com.gharibe.kk.android.datasource.cache.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Singleton
    @Provides
    fun provideRecipeDatabase(context: BaseApplication):RecipeDatabase{
        return RecipeDataBaseFactory(driverFactory = DriverFactory(context)).createDatabase()
    }
    @Singleton
    @Provides
    fun provideRecipeCache(
        recipeDatabase: RecipeDatabase
    ): RecipeCache{
        return RecipeCacheImpl(
            recipeDatabase= recipeDatabase,
            datetimeUtil = DatetimeUtil()
        )
    }
}