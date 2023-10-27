package com.example.taskapp.domain.di

import com.example.taskapp.domain.repository.SpaceCraftsRepo
import com.example.taskapp.domain.use_cases.GetSpaceCraftListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun providGetSpaceCraftListUseCase(spaceCraftsRepo: SpaceCraftsRepo) : GetSpaceCraftListUseCase {
        return GetSpaceCraftListUseCase(spaceCraftsRepo)
    }
}