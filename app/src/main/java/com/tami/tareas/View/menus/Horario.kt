package com.tami.tareas.View.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.tami.tareas.R
import com.tami.tareas.View.Screen
import com.tami.tareas.View.web


@Composable
fun horario(modifier:Modifier, navController: NavHostController) {
    Column (modifier = modifier){
        Box(modifier = Modifier.padding(16.dp)){
            Image(modifier)
        }

        Box(modifier = Modifier.padding(16.dp)){
            backHorario(Modifier.fillMaxWidth().height(100.dp), navController)
        }

    }
}

//la imagen del horario
@Composable
fun Image(modifier: Modifier){
    LazyRow (modifier = modifier.fillMaxWidth().height(500.dp) , verticalAlignment = Alignment.CenterVertically, horizontalArrangement =  Arrangement.Center){
        item {
            Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center ){
                Image(painter = painterResource(id = R.drawable.horario), contentDescription = "Horario")
            }
        }
    }
}
//boton de retroceder
@Composable
fun backHorario(modifier: Modifier, navController: NavController) {

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