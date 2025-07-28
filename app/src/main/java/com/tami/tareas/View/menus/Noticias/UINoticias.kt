package com.tami.tareas.View.menus.Noticias

import android.net.Uri
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tami.tareas.View.Screen

@Composable
fun UINoticias(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier) {
        listado(viewModel =  viewModel(), navController)
    }
}

@Composable
fun listado(viewModel: NoticiasViewModel = viewModel(), navController: NavHostController) {
    val noticiasLista by viewModel.noticias.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.cargarNoticias()
    }

    LazyColumn {
        items(noticiasLista) { noticia ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(130.dp),
                onClick = {
                    navController.navigate("${Screen.NoticasCompletas}/${noticia.title}/${Uri.encode(noticia.pubDate)}/${Uri.encode(noticia.link)}/${Uri.encode(noticia.content)}/${Uri.encode(noticia.description)}/${Uri.encode(noticia.image_url)}")
                }
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = noticia?.title ?: "Sin título",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = noticia?.pubDate ?: "Fecha desconocida")
                }
            }
        }
    }
}

