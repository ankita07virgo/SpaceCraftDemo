package com.example.taskapp.domain.repository

import com.example.taskapp.domain.model.SpaceCrafts

interface SpaceCraftsRepo {
    suspend fun getSpaceCraftsList() : SpaceCrafts
}