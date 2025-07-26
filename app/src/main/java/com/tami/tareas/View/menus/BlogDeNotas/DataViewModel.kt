package com.tami.tareas.View.menus.BlogDeNotas

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tami.tareas.View.menus.Tareas.DataDaoTareas
import com.tami.tareas.View.menus.Tareas.DataTareas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

//Corrutina para guardar en la vase de datos
@HiltViewModel
class notasUseViewModel @Inject constructor (private val dataDao: DaoBlogDeNotas): ViewModel() {

    val date: StateFlow<List<DataBlogDeNotas?>> = dataDao.getAllNotas()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    //insertar
    fun SaveNotas(text: DataBlogDeNotas) {
        viewModelScope.launch {
            Log.i("insert", "se paso por el viewModel correctamente")
            dataDao.insertAllNotas(text)
        }
    }

    fun DeleteNotas(text: Int) {
        viewModelScope.launch {
            Log.i("delete", "se paso por el viewModel correctamente")
            dataDao.deleteNotas(text)
        }
    }
}