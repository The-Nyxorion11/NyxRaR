package com.tami.tareas.View.menus.BlogDeNotas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun UiNotes(modifier: Modifier, navController1: NavController, notas: NotasClass) {
    Column (modifier){
        titulo(modifier, notas)

    }

}

@Composable
fun titulo(modifier: Modifier, notas: NotasClass) {
    var titulo by rememberSaveable { mutableStateOf("") }
    var contenido by rememberSaveable { mutableStateOf("") }

    val viewModel: notasUseViewModel = hiltViewModel()


    titulo = notas.titulo
    contenido = notas.contenido

    LazyColumn {
        item {
            TextField(
                value = titulo,
                onValueChange = { titulo = it },
                modifier = Modifier.padding(top = 30.dp).fillMaxWidth(),
                singleLine = true,
                label = {Text("Titulo")}

            )

            TextField(
                value = contenido,
                onValueChange = { contenido = it },
                modifier = Modifier.padding(top = 30.dp, bottom = 30.dp).fillMaxWidth().height(500.dp),
                label = {Text("Contenido")}
            )

            Button(onClick = {
                val content = DataBlogDeNotas(id = notas.id ,titulo = titulo, contenido = contenido)

                viewModel.SaveNotas(content)
            },
                modifier = Modifier.fillMaxWidth().height(100.dp)
                ) {
                Text("Guardar Nota", fontSize = 50.sp)
            }
        }
    }
}

