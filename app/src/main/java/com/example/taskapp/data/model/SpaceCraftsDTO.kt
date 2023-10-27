package com.example.taskapp.data.model

import com.example.taskapp.data.model.CraftDTO
import com.google.gson.annotations.SerializedName

data class SpaceCraftsDTO(
    @SerializedName("spacecrafts")
    val craftsDTO: List<CraftDTO>
)