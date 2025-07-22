package com.tami.tareas.View.menus.Tareas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.firstOrNull
import android.util.Log


//Corrutina para guardar en la vase de datos
@HiltViewModel
class tareasUseViewModel @Inject constructor (private val dataDao: DataDaoTareas): ViewModel() {

    val date: StateFlow<List<DataTareas?>> = dataDao.getAllTareas()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    //insertar
    fun SaveTarea(text: DataTareas) {
        viewModelScope.launch {
            Log.i("insert", "se paso por el viewModel correctamente")
            dataDao.insertAllTareas(text)
        }
    }

    fun DeleteTarea(text: Int) {
        viewModelScope.launch {
            Log.i("delete", "se paso por el viewModel correctamente")
            dataDao.deleteItem(text)
        }
    }
}