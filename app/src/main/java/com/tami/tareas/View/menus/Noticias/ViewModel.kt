package com.tami.tareas.View.menus.Noticias

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.util.Log

class NoticiasViewModel : ViewModel() {
    private val repo = NoticiasRepository()

    private val _noticias = MutableStateFlow<List<Noticia>>(emptyList())
    val noticias: StateFlow<List<Noticia>> = _noticias


    fun cargarNoticias() {
        viewModelScope.launch {
            try {
                repo.obtenerNoticias().collect { lista ->
                    _noticias.value = lista
                }
            } catch (e: Exception) {
                Log.e("NoticiasViewModel", "Error al cargar noticias", e)
                _noticias.value = emptyList() // evita null si algo se rompe
            }
        }
    }
}