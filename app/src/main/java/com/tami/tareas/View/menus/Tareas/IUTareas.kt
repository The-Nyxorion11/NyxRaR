package com.tami.tareas.View.menus.Tareas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tami.tareas.R
import com.tami.tareas.View.menus.Image

data class Tarea(val id: Int, val texto: String, val tiempo: Int)
//Ui
@Composable
fun IUTareas(modifier: Modifier, navController: NavHostController) {

    Column (modifier){
        lista(Modifier.padding(10.dp), navController)
    }
}


@Composable
fun lista(modifier: Modifier, navController: NavHostController) {
    var text by rememberSaveable { mutableStateOf("") }
    var horas by rememberSaveable { mutableStateOf("") }
    var minutos by rememberSaveable { mutableStateOf("") }

    val viewModel: tareasUseViewModel = hiltViewModel()
    val tareas by viewModel.date.collectAsState()
    val context = LocalContext.current


    Column{
        //nombre
        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("name") },
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier.fillMaxWidth()) {

            //horas
            TextField(
                value = horas,
                onValueChange = { newText -> horas = newText },
                label = { Text("Horas") },
                modifier = modifier.width(150.dp)
            )

            Spacer(modifier = Modifier.width(45.dp))

            //minutos
            TextField(
                value = minutos,
                onValueChange = { newText -> minutos= newText },
                label = { Text("Minutos") },
                modifier = modifier.width(150.dp)
            )
        }
        val tiempoTotal = horas.padStart(2, '0') + minutos.padStart(2, '0')


        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                if (text.isNotBlank()) {

                    val nuevaTarea = DataTareas(name = text, time = tiempoTotal.toInt())
                    viewModel.SaveTarea(nuevaTarea)
                    text = ""
                    horas = ""
                    minutos = ""
                    programarNotificacion(context, nuevaTarea)
                }
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth().height(60.dp)
        ) {
            Text(text = "+", fontSize = 30.sp)
        }

        LazyColumn {
            items(tareas) { tarea ->
                card(Tarea(id = tarea!!.id, texto = tarea.name, tiempo = tarea.time))
            }
        }
    }
}



@Composable
fun card(tarea: Tarea) {
    val viewModel: tareasUseViewModel = hiltViewModel()
    val horas = tarea.tiempo /100
    val minutos = tarea.tiempo % 100

    val total = horas.toString() + ":" + minutos.toString()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(100.dp),

        elevation = CardDefaults.cardElevation(4.dp),
        onClick = {
            viewModel.DeleteTarea(tarea.id)
        }
    ) {
        Row {
            Text(
                text = tarea.texto,
                fontSize = 30.sp,
                modifier = Modifier.padding(30.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = total,
                modifier = Modifier.padding(30.dp),
            )

        }
    }
}


