package com.tami.tareas.View.menus.Tareas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DataDaoTareas {
    @Query("SELECT* FROM Tareas")
    fun getAllTareas(): Flow<List<DataTareas>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTareas(text: DataTareas)

    @Query("Delete FROM Tareas WHERE id = :id")
    suspend fun deleteItem(id: Int)
}