package com.tami.tareas.View.menus.BlogDeNotas

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tami.tareas.View.Colors.DeepMidnightBlue
import com.tami.tareas.View.Colors.TwilightIndigo
import com.tami.tareas.View.Screen
import com.tami.tareas.View.menus.Lista.listaUseViewModel

//para conectar con la base de datos
data class NotasClass(val id: Int, val titulo: String, val contenido: String)

@Composable
fun NotasLista(modifier: Modifier, navController: NavController) {
    Column {
        listado(modifier, navController)
    }
}

@Composable
fun listado(modifier: Modifier, navController: NavController) {
    var mostrarPopup by rememberSaveable { mutableStateOf(false) }
    var titulo by rememberSaveable { mutableStateOf("") }

    // room
    val viewModel: notasUseViewModel = hiltViewModel()
    val notas by viewModel.date.collectAsState()

    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = titulo,
            onValueChange = { newtext -> titulo = newtext },
            modifier = Modifier.width(300.dp).height(60.dp).background(color = DeepMidnightBlue).padding(top = 10.dp),

            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = DeepMidnightBlue,
                unfocusedContainerColor = TwilightIndigo
            ),

            label = {Text("Titulo")}
        )

        Button(
            onClick = {
                mostrarPopup = false
                if (titulo.isNotBlank()){
                    val nuevaTarea = DataBlogDeNotas(titulo = titulo, contenido = "")
                    viewModel.SaveNotas(nuevaTarea)
                    titulo = ""
                }
            },
            modifier = Modifier.width(200.dp).height(60.dp).padding(top = 10.dp)


        ) {
            Text(text = "+")
        }

        notaLista(titulo, navController)

    }
}



@Composable
fun notaLista(titulo: String, navController: NavController) {
    val viewModel: notasUseViewModel = hiltViewModel()
    val notas by viewModel.date.collectAsState()
    val context = LocalContext.current


    LazyColumn() {
        items(notas) { notes ->
            notasCards(NotasClass(id = notes!!.id, titulo = notes.titulo, contenido = notes.contenido), navController)
        }
    }

}

@Composable
fun notasCards(notas: NotasClass, navController: NavController) {
    val viewModel: notasUseViewModel = hiltViewModel()
    var permiso by rememberSaveable { mutableStateOf(false) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(100.dp),

        elevation = CardDefaults.cardElevation(4.dp),
        onClick = {
            navController.navigate("${Screen.NotasLista}/${notas.id}/${Uri.encode(notas.titulo)}/${Uri.encode(notas.contenido)}")
            permiso = true
        }

    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Text(
                text = notas.titulo,
                fontSize = 30.sp,
                modifier = Modifier.padding(30.dp)
            )

            Spacer(modifier = Modifier.weight(10f))
            Button(
                onClick = {
                viewModel.DeleteNotas(notas.id)
            },
                modifier = Modifier.padding(30.dp),

                ) {
                Text(text = "<-")
            }

        }
    }
}

