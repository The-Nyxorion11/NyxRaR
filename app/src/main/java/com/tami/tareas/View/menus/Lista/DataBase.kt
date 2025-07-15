package com.tami.tareas.View.menus.Lista

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lista")
data class listaData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content : String
)