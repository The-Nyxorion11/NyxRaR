package com.tami.tareas.View.menus.Note
//paso 1, lo que contiene el blog de notas
import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Long,
    var title: String,
    var content: String,
    val timestamp: Long
)