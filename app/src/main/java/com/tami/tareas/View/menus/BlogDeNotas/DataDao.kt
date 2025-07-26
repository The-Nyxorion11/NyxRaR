package com.tami.tareas.View.menus.BlogDeNotas

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoBlogDeNotas {
    @Query("SELECT * FROM BlogDeNotas")
    fun getAllNotas(): Flow<List<DataBlogDeNotas>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNotas(text: DataBlogDeNotas)

    @Query("Delete FROM BlogDeNotas WHERE id = :id")
    suspend fun deleteNotas(id: Int)
}