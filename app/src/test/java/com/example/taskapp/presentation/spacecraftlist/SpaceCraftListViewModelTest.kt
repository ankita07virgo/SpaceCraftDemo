package com.example.taskapp.presentation.spacecraftlist

import app.cash.turbine.test
import app.cash.turbine.turbineScope
import com.example.democleanmvvm.common.Resource
import com.example.taskapp.domain.model.Craft
import com.example.taskapp.domain.model.SpaceCrafts
import com.example.taskapp.domain.use_cases.GetSpaceCraftListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class SpaceCraftListViewModelTest{
    @Mock
    private lateinit var mGetSpaceCraftListUseCase: GetSpaceCraftListUseCase

    @ExperimentalCoroutinesApi
    var corountineRule = StandardTestDispatcher()

    private lateinit var viewModel: SpaceCraftListViewModel

    @Before
    fun setUp(){
        Dispatchers.setMain(corountineRule)
    }
    @ExperimentalCoroutinesApi
    @Test
    fun getSpaceCraftList() = runTest {
        val spaceCraftList =
            listOf(Craft(1,"Aryabhata") , Craft(2,"Bhaskara-I"))
        val spaceCraft = SpaceCrafts(spaceCraftList)

        val mSpaceCraftState = SpaceCraftState(data = spaceCraft)
        Mockito.`when`(mGetSpaceCraftListUseCase.invoke(corountineRule)).thenReturn(flowOf(Resource.Success(data = spaceCraft)))

        viewModel = SpaceCraftListViewModel(getSpaceCraftListUseCase = mGetSpaceCraftListUseCase, ioDispatcher = corountineRule)

        turbineScope {
            viewModel.list.test {
                skipItems(1)
                assertEquals(awaitItem(),mSpaceCraftState)
            }
        }
    }

}