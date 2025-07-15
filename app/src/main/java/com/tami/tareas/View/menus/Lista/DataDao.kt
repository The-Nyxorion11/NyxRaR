package com.tami.tareas.View.menus.Lista

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DataDao{
    @Query("SELECT * FROM lista WHERE id = :id")
    fun getAll(id: Int): Flow<listaData?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetrAll(text : listaData): Long

}