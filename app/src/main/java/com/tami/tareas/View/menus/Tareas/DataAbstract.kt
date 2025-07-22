package com.tami.tareas.View.menus.Tareas

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tami.tareas.View.menus.Lista.DataDao
import com.tami.tareas.View.menus.Lista.listaData

@Database(entities = [DataTareas::class], version = 1)
abstract class DataAbstractTareas: RoomDatabase(){
    abstract fun DataDaoTareas(): DataDaoTareas
}