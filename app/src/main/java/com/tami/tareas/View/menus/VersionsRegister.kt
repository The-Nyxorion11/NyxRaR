package com.tami.tareas.View.menus

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.tami.tareas.View.Screen


@Composable
fun registerVersions(modifier: Modifier, navController: NavHostController) {
    LazyColumn (modifier = modifier) {
        item {
            texto()
            Spacer(modifier = Modifier.height(20.dp))
            backVersions(modifier, navController)
        }
    }
}


@Composable
fun texto(){
    Text(text = "VERSION 1.0.0:" +
            "\n -Se agrego apartado de webs" +
            "\n -Se creo la app" +
            "\n -Se agrego el Horario" +
            "\n" +
            "\nVERSION 1.1.0:" +
            "\n -Se agrego ChatGPT a la web" +
            "\n -Se agrego el registro de versiones" +
            "\n -Se cambio el nombre de la app" +
            "\n -Se arreglaron bugs" +
            "\n"+
            "\nVERSION 1.2.0:" +
            "\n -Se Agrego la lista" +
            "\n -Se agrego el room" +
            "\n" +
            "\nBugfix 1.2.1:" +
            "\n -Se arreglaron bugs" +
            "\n -Se cambio el icono de esta activity",


        fontSize = 25.sp)
}

@Composable
fun backVersions(modifier: Modifier, navController: NavController) {

    Card (modifier= modifier, onClick = {navController.navigate(Screen.Menu)}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "🔙Atrás",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}