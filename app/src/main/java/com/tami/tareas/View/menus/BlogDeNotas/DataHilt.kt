package com.tami.tareas.View.menus.BlogDeNotas

import android.app.Application
import androidx.room.Room
import com.tami.tareas.View.menus.Tareas.DataAbstractTareas
import com.tami.tareas.View.menus.Tareas.DataDaoTareas
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleNotas {
    @Provides
    @Singleton
    fun provideDataBaseNotas(app: Application): DataAbstractNotas {
        return Room.databaseBuilder(app, DataAbstractNotas::class.java, "DataAbstractNotas")
            .build()
    }

    @Provides
    fun provideContentNotas(db: DataAbstractNotas): DaoBlogDeNotas = db.DaoBlogDeNotas()
}