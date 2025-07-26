package com.tami.tareas.View.menus.Notificaciones

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.tami.tareas.R
import android.util.Log

class NotificacionesRecivers: BroadcastReceiver() {
    @SuppressLint("ServiceCast")
    override fun onReceive(context: Context, intent: Intent) {

        Log.i("RECEIVER", "¡BroadcastReceiver ejecutado!")

        // 1. Extraer los datos que enviamos desde el intent
        val titulo = intent.getStringExtra("titulo") ?: "TAREA CHAVAL"
        val mensaje = intent.getStringExtra("mensaje") ?: "NUEVA TAREAAAA, Revisa la barra de tareas!!"

        //accede al servicio de notificaciones
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 2. Si el dispositivo tiene Android 8+ (API 26), crea un canal de notificación
        if (Build.VERSION.SDK_INT >= 26) {
            val canal = NotificationChannel(
                "Tareas", // ID del canal (debe coincidir con el usado en Builder)
                "Tareas", // Nombre del canal que ve el usuario
                NotificationManager.IMPORTANCE_HIGH // Qué tan importante es
            )
            manager.createNotificationChannel(canal)
        }

        // crea una notificacion
        val n = NotificationCompat.Builder(context, "Tareas")
            .setContentTitle(titulo)//titulo
            .setContentText(mensaje)//texto
            .setSmallIcon(R.drawable.nyxappricon)//iconohh
            .setPriority(NotificationCompat.PRIORITY_HIGH) // 🔥 Esto es clave
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .build()


        Log.i("NOTIFICACIONFINAL","TODO ESTA EN ORDEN tiempo")
        // 4. Muestra la notificación
        manager.notify(1, n) // El ID 1 puede usarse luego para actualizar o cancelar
    }
}