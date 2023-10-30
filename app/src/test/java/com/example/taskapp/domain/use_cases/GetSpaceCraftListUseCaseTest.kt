package com.example.taskapp.domain.use_cases

import com.example.taskapp.common.Resource
import com.example.taskapp.domain.model.Craft
import com.example.taskapp.domain.model.SpaceCrafts
import com.example.taskapp.domain.repository.SpaceCraftsRepo
import com.example.taskapp.presentation.spacecraftlist.SpaceCraftState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetSpaceCraftListUseCaseTest {
    private val mSpaceCraftRepo = mockk<SpaceCraftsRepo>()
    private lateinit var mGetSpaceCraftListUseCase: GetSpaceCraftListUseCase

    @ExperimentalCoroutinesApi
    var coroutineRule = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(coroutineRule)
        mGetSpaceCraftListUseCase = GetSpaceCraftListUseCase(mSpaceCraftRepo)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `verify getSpaceCraftUseCase`() = runTest {
        val spaceCraftList =
            listOf(Craft(1, "Aryabhata"), Craft(2, "Bhaskara-I"))
        val spaceCraft = SpaceCrafts(spaceCraftList)
        val mSpaceCraftState = SpaceCraftState(data = spaceCraft)

        coEvery { mSpaceCraftRepo.getSpaceCraftsList() } returns spaceCraft
        val result: Flow<Resource<SpaceCrafts>> = mGetSpaceCraftListUseCase.invoke(coroutineRule)

        result.collectLatest {
            when (it) {
                is Resource.Success -> {
                    assertEquals(it.data, mSpaceCraftState.data)
                }

                else -> {}
            }

        }
    }
}