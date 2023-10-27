package com.example.taskapp.presentation.spacecraftlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democleanmvvm.common.Resource
import com.example.taskapp.domain.use_cases.GetSpaceCraftListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SpaceCraftListViewModel @Inject constructor(private val getSpaceCraftListUseCase: GetSpaceCraftListUseCase,
    @Named("io") private val ioDispatcher: CoroutineDispatcher) :
    ViewModel() {
        private val _list = MutableStateFlow<SpaceCraftState>(SpaceCraftState())
    val list : StateFlow<SpaceCraftState> = _list

    init {
        getSpaceCraftList()
    }

    private fun getSpaceCraftList(){
        viewModelScope.launch {
            getSpaceCraftListUseCase(ioDispatcher).collectLatest {
                when(it) {
                    is Resource.Loading-> {
                        _list.value = SpaceCraftState(isLoading = true)
                    }
                    is Resource.Success-> {
                        _list.value = SpaceCraftState(data = it.data)
                    }

                    is Resource.Error-> {
                        _list.value = SpaceCraftState(error = it.message.toString())
                    }



                }
            }
        }


    }
}