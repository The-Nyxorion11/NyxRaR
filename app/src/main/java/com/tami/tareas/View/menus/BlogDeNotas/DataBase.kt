package com.tami.tareas.View.menus.BlogDeNotas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BlogDeNotas")
data class DataBlogDeNotas(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val contenido: String
) {
    // You can add additional properties or methods if needed
}