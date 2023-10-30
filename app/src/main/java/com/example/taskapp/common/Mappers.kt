package com.example.taskapp.common

import com.example.taskapp.data.model.CraftDTO
import com.example.taskapp.data.model.SpaceCraftsDTO
import com.example.taskapp.domain.model.Craft
import com.example.taskapp.domain.model.SpaceCrafts

fun SpaceCraftsDTO.toDomain(): SpaceCrafts {
    return SpaceCrafts(spaceCrafts = craftsDTO.map{it.toDomain()})
}

fun CraftDTO.toDomain(): Craft {
    return Craft(id = id,name = name)
}
