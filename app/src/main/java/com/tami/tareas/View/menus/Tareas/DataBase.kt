package com.tami.tareas.View.menus.Tareas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tareas")
data class DataTareas(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name : String,
    val time: Int
)