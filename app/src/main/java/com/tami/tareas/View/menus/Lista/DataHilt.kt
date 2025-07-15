package com.tami.tareas.View.menus.Lista

import android.app.Application
import androidx.room.Insert
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Provides
    @Singleton
    fun provideDataBase(app: Application): DataAbstract{
        return Room.databaseBuilder(app, DataAbstract::class.java, "DataAbstract").build()
    }

    @Provides
    fun provideContent(db: DataAbstract): DataDao = db.dataDao()
}