package com.example.taskapp.data.model

import com.google.gson.annotations.SerializedName

data class SpaceCraftsDTO(
    @SerializedName("spacecrafts")
    val craftsDTO: List<CraftDTO>
)