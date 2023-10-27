package com.example.taskapp.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object DispatcherModule {

    @Named("io")
    @Provides
    fun provideIODispatcher() = Dispatchers.IO

    @Named("main")
    @Provides
    fun provideMainDispatcher() = Dispatchers.Main

    @Named("default")
    @Provides
    fun provideDefaultDispatcher() = Dispatchers.Default
}