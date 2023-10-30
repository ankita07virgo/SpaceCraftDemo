package com.example.taskapp.data.network

import com.example.taskapp.data.model.SpaceCraftsDTO
import retrofit2.http.GET

interface ApiService {

    @GET("/api/spacecrafts")
    suspend fun getSpaceCraftList() : SpaceCraftsDTO
}