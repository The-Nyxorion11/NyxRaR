package com.tami.tareas.View.menus.Lista

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun listaUi(modifier: Modifier, navController: NavHostController) {
    Column (modifier = modifier){
        listado()
    }
}

@Composable
fun listado() {
    var number by rememberSaveable { mutableIntStateOf(1) }
    var text by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    //agrega la inyeccion hilt
    val viewModel: listaUseViewModel = hiltViewModel()
    val date by viewModel.date.collectAsState()
    val permiso by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(date) {
        if (number == 1 && date != null) {
            text = date!!.content
            number++
        }
    }


    Column {
        TextField(
            value = text,
            onValueChange = { Unit -> text = Unit},
            modifier = Modifier.fillMaxWidth().height(100.dp)
        )

        Button(onClick = {
            val content = listaData(id = 1, content = text)

            viewModel.Savelista(content)

            Toast.makeText(context, "Guardado exitosamente", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Guardar")
        }
    }
}
