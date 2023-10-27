package com.example.taskapp.presentation.spacecraftlist

import com.example.taskapp.domain.model.Craft
import com.example.taskapp.domain.model.SpaceCrafts

data class SpaceCraftState(  val isLoading:Boolean=false,
                             val error:String="",
                             val data:SpaceCrafts?=null)
