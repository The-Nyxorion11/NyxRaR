package com.tami.tareas.View.menus.BlogDeNotas

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [DataBlogDeNotas::class], version = 1)
abstract class DataAbstractNotas: RoomDatabase(){
    abstract fun DaoBlogDeNotas(): DaoBlogDeNotas
}