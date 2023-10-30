package com.example.taskapp.domain.use_cases

import com.example.taskapp.common.Resource
import com.example.taskapp.domain.model.SpaceCrafts
import com.example.taskapp.domain.repository.SpaceCraftsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetSpaceCraftListUseCase(private val spaceCraftsRepo: SpaceCraftsRepo) {

    operator fun invoke(mDispatcher: CoroutineDispatcher): Flow<Resource<SpaceCrafts>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = spaceCraftsRepo.getSpaceCraftsList()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(mDispatcher)
}