package com.tami.tareas.View.menus.Noticias

import kotlinx.coroutines.flow.Flow


data class DataResponseNews(
    val results: List<Noticia> = emptyList()
)

data class Noticia(
    val title: String,
    val link: String,
    val pubDate: String,
    val source_id: String,
    val content:String,
    val description: String,
    val image_url: String
)