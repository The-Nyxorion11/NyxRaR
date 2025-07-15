package com.tami.tareas.View.menus.Lista

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [listaData::class], version = 1)
abstract class DataAbstract: RoomDatabase(){
    abstract fun dataDao(): DataDao
}