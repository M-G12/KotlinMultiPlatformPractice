package com.example.kk.android.di

import com.example.kk.datasource.KtorClientFactory
import com.example.kk.datasource.network.RecipeService
import com.example.kk.datasource.RecipeServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient{
        return KtorClientFactory().build()
    }
    @Singleton
    @Provides
    fun provideRecipeService(
        httpClient: HttpClient,
    ): RecipeService{
        return RecipeServiceImpl(
            httpClient = httpClient,
        )
    }
}