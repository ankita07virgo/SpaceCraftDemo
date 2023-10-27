package com.example.taskapp.data.model

import com.google.gson.annotations.SerializedName

data class CraftDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)