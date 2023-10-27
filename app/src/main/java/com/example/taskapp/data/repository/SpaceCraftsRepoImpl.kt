package com.example.taskapp.data.repository

import com.example.taskapp.common.toDomain
import com.example.taskapp.data.network.ApiService
import com.example.taskapp.domain.model.SpaceCrafts
import com.example.taskapp.domain.repository.SpaceCraftsRepo

class SpaceCraftsRepoImpl(private val apiService: ApiService): SpaceCraftsRepo {
    override suspend fun getSpaceCraftsList(): SpaceCrafts {
        return apiService.getSpaceCraftList().toDomain()
    }
}