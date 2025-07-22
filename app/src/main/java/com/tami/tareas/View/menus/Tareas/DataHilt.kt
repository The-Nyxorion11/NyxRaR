package com.tami.tareas.View.menus.Tareas

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleTareas {
    @Provides
    @Singleton
    fun provideDataBaseTareas(app: Application): DataAbstractTareas {
        return Room.databaseBuilder(app, DataAbstractTareas::class.java, "DataAbstractTareas")
            .build()
    }

    @Provides
    fun provideContentTareas(db: DataAbstractTareas): DataDaoTareas = db.DataDaoTareas()
}