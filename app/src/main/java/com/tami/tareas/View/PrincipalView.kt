package com.tami.tareas.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.tami.tareas.View.menus.webApps

object Screen {
    const val Menu = "menu"
    const val Webs = "webs"
}

@Composable
fun appNavigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Menu
    ){
        composable(Screen.Menu){
            menu(Modifier.fillMaxSize().padding(paddingValues), navController = navController)
        }
        composable(Screen.Webs){
            webApps(navController = navController)
        }
    }
}




@Composable
fun menu(modifier: Modifier, navController: NavController) {


    LazyColumn (modifier = modifier){
        item {

            Box(modifier = Modifier.padding(16.dp)){
                web(Modifier.fillMaxWidth().height(100.dp), navController)
            }
        }
    }

}


@Composable
fun web(modifier: Modifier, navController: NavController) {

    Card (modifier= modifier, onClick = {navController.navigate(Screen.Webs)}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "Webs",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}