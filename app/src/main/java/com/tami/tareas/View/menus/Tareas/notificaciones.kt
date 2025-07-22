package com.tami.tareas.View.menus.Tareas

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.tami.tareas.View.menus.Notificaciones.NotificacionesRecivers
import kotlin.jvm.java
import android.provider.Settings
import android.util.Log
import java.util.Calendar


@SuppressLint("ServiceCast")
fun programarNotificacion(context: Context, nuevaTarea: DataTareas) {

    try {
        val tarea = nuevaTarea.time
        val tiempo = tarea
        val titulo = nuevaTarea.name

        //calcula la hora con tiempo militar

        val hora = tiempo / 100
        val minutos = tiempo % 100

        //saca la hora actual
        val ahora = Calendar.getInstance()

        //hace el calculo
        val notiCal = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hora)
            set(Calendar.MINUTE, minutos)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)

            // Si ya pasó, prográmala para mañana
            if (before(ahora)) {
                add(Calendar.DAY_OF_YEAR, 1)
            }
        }


        // 1. Crear un Intent que ejecutará el NotificationReceiver (clase que muestra la notificación)
        val intent = Intent("com.tami.tareas.NOTIFICACION_PROGRAMADA").apply {
            setClass(context, NotificacionesRecivers::class.java)
            putExtra("titulo", titulo)
            putExtra("mensaje", "TAREAA!!")
        }


        // 2. Crear un PendingIntent, que es como una orden programada para ejecutarse en el futuro
        val pi = PendingIntent.getBroadcast(
            context,
            (System.currentTimeMillis() % Int.MAX_VALUE).toInt(), // ID único basado en el tiempo actual
            intent,
            PendingIntent.FLAG_IMMUTABLE // Requerido desde Android 12+
        )

        // 3. Obtener el servicio del sistema que maneja alarmas
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // 4. Verificar si el permiso para alarmas exactas está activo (necesario en Android 12+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            !alarmManager.canScheduleExactAlarms()) {

            // Si no está activo, pedirle al usuario que lo habilite manualmente en ajustes
            val settingsIntent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
            settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // Para que se abra fuera de la app
            context.startActivity(settingsIntent)
            return // Salimos de la función hasta que el usuario dé el permiso
        }

        // 5. Programar la notificación para el futuro (exactamente después de "delayMillis")
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP, // Usa el reloj real del sistema y despierta el dispositivo si está dormido
            notiCal.timeInMillis, // Momento exacto en el que queremos la notificación
            pi // Qué debe pasar cuando llegue ese momento
        )
        Log.d("NOTIFICACION", "Programando para $hora:$minutos")
        Log.d("TIEMPO", notiCal.time.toString())
    }catch (e : Exception){
        Log.e("NOTIFICACION", "Error ${e}",e)
    }
}


