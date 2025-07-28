package com.tami.tareas.View.menus.Noticias

import android.R.attr.color
import android.R.color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.SnackbarDefaults.color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.tami.tareas.View.Colors.TwilightIndigo

@Composable
fun UINoticiaCompleta(
    modifier: Modifier,
    navController: NavHostController,
    title: String,
    pubDate: String,
    link: String,
    content: String,
    description: String,
    imageUrl: String
) {
    LazyColumn(modifier) {
        item{
            tituloNoticia(title)
            Spacer(modifier = Modifier.height(20.dp))
            imagenNoticia(imageUrl)
            Spacer(modifier = Modifier.height(20.dp))
            pubDateNoticia(pubDate)
            Spacer(modifier = Modifier.height(20.dp))
            descripcionNoticia(description)
            Spacer(modifier = Modifier.height(20.dp))
            contenidoNoticia(content)

        }
    }
}

@Composable
fun tituloNoticia(title: String) {
    Column{
        Box (modifier = Modifier.fillMaxWidth().background(TwilightIndigo)) {
            Text(text = title, fontSize = 25.sp)
        }

    }
}

@Composable
fun imagenNoticia(imageUrl: String) {
    Column{
        AsyncImage(
            model = imageUrl,
            contentDescription = "Imagen de la noticia",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun pubDateNoticia(pubDate: String) {
    Column{

        Text(text = pubDate, fontSize = 20.sp)
    }
}

@Composable
fun descripcionNoticia(description: String) {
    Column{
        Text(text = "Descripcion:", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Box (modifier = Modifier.fillMaxWidth().background(TwilightIndigo)) {

            Text(text = description, fontSize = 20.sp)
        }
    }
}

@Composable
fun contenidoNoticia(content: String) {
    Column{
        Text(text = "Contenido:", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Box (modifier = Modifier.fillMaxWidth().background(TwilightIndigo)) {
            Text(text = content, fontSize = 20.sp)
        }
    }
}


