package com.tami.tareas.View.menus.Lista

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.tami.tareas.View.Screen
import java.nio.file.WatchEvent


@Composable
fun listaUi(modifier: Modifier, navController: NavHostController) {
    Column (modifier = modifier){
        listado(Modifier.padding(10.dp))
        backHorario(Modifier.padding(20.dp), navController)
    }
}

@Composable
fun listado(modifier: Modifier) {
    var number by rememberSaveable { mutableIntStateOf(1) }
    var text by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    //agrega la inyeccion hilt
    val viewModel: listaUseViewModel = hiltViewModel()
    val date by viewModel.date.collectAsState()

    LaunchedEffect(date) {
        if (number == 1 && date != null) {
            text = date!!.content
            number++
        }
    }


    Column{
        TextField(
            value = text,
            onValueChange = { Unit -> text = Unit},
            modifier = Modifier.fillMaxWidth().height(450.dp).padding(10.dp),
        )

        Button(onClick = {
            val content = listaData(id = 1, content = text)

            viewModel.Savelista(content)

            Toast.makeText(context, "Guardado exitosamente", Toast.LENGTH_SHORT).show()
        }, modifier = modifier.height(100.dp).fillMaxWidth()) {

            Text(text = "Guardar", fontSize = 50.sp)

        }
    }
}
//boton de retroceder
@Composable
fun backHorario(modifier: Modifier, navController: NavController) {

    Card (modifier = modifier, onClick = {navController.navigate(Screen.Menu)}){
        Row (
            Modifier.fillMaxWidth().height(100.dp),
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
