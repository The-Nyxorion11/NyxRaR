package com.tami.tareas.View.menus.Lista

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp


//inicializa el hilt
@HiltAndroidApp
class Myapp: Application(){
    //para no tener que poner otro name en AndroidManifest
    override fun onCreate() {
        super.onCreate()
    }
}