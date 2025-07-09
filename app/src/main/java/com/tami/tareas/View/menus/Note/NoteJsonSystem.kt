package com.tami.tareas.View.menus.Note

import android.content.Context
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter

const val NOTES_FILE_NAME = "notes.json"

//funcion para guardar la lista de archivos json
fun savaNotesToFiles(context: Context, note: List<Note>){
    val jsonString = Json.encodeToString(note) //Convertir la lista de notas a json
    context.openFileOutput(NOTES_FILE_NAME, Context.MODE_PRIVATE).use { outputStream ->
        OutputStreamWriter(outputStream).use {
            write -> write.write(jsonString)
        }
    }
}

// Función para cargar la lista de notas desde un archivo JSON interno
fun loadNotesFromFile(context: Context): List<Note> {
    return try {
        context.openFileInput(NOTES_FILE_NAME).use { inputStream ->
            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                val jsonString = reader.readText()
                Json.decodeFromString<List<Note>>(jsonString) // Convertir JSON a lista de notas
            }
        }
    } catch (e: FileNotFoundException) {
        // Si el archivo no existe (primera vez que se ejecuta la app), retornar una lista vacía
        emptyList()
    } catch (e: Exception) {
        // Manejar otros errores de deserialización o lectura
        e.printStackTrace()
        emptyList()
    }
}