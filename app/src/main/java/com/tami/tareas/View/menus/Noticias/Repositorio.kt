package com.tami.tareas.View.menus.Noticias

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import android.util.Log

class NoticiasRepository {
    fun obtenerNoticias(): Flow<List<Noticia>> = flow {
        val response = RetrofitInstance.api.getNews(
            apikey = "pub_3e30f7d3b1a44d16b67e294b5fa96a84",
            country = "us",
            language = "es",
            category = "politics")

        Log.d("REPO", "Respuesta cruda: $response") // ✅ DEBUG

        emit(response.results)
    }
}