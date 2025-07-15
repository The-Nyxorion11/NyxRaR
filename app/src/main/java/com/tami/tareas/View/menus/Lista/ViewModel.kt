package com.tami.tareas.View.menus.Lista

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingCommand
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

//Corrutina para guardar en la vase de datos
@HiltViewModel
class listaUseViewModel @Inject constructor (private val dataDao: DataDao): ViewModel(){

    //cargar
    val date : StateFlow<listaData?> = dataDao.getAll(1)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    //insertar
    fun Savelista(text: listaData){

        viewModelScope.launch {

            dataDao.insetrAll(text)

        }
    }
}