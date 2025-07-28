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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tami.tareas.View.menus.BlogDeNotas.NotasClass
import com.tami.tareas.View.menus.BlogDeNotas.NotasLista
import com.tami.tareas.View.menus.BlogDeNotas.UiNotes
import com.tami.tareas.View.menus.BlogDeNotas.notasUseViewModel
import com.tami.tareas.View.menus.Lista.listaUi
import com.tami.tareas.View.menus.Noticias.UINoticiaCompleta
import com.tami.tareas.View.menus.Noticias.UINoticias
import com.tami.tareas.View.menus.Tareas.IUTareas
import com.tami.tareas.View.menus.horario
import com.tami.tareas.View.menus.registerVersions
import com.tami.tareas.View.menus.webApps

object Screen {
    const val Menu = "menu"
    const val Webs = "webs"
    const val Horario = "horario"
    const val Lista = "Lista"
    const val Veriones = "Versiones"
    const val Tareas = "Tareas"
    const val Notas = "Notas"
    const val Noticias = "Noticias"

    //especiales
    const val NotasLista = "NotasLista"
    const val NoticasCompletas = "NoticasCompletas"
}




@Composable
fun appNavigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    //room de las notas
    val viewModel: notasUseViewModel = hiltViewModel()
    val notas by viewModel.date.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.Menu
    ){
        composable(Screen.Menu){
            menu(Modifier
                .fillMaxSize()
                .padding(paddingValues), navController = navController)
        }
        composable(Screen.Webs){
            webApps(Modifier.padding(paddingValues), navController = navController)
        }
        composable (Screen.Horario){
            horario(Modifier.padding(paddingValues), navController = navController)
        }
        composable (Screen.Veriones) {
            registerVersions(Modifier.padding(paddingValues), navController = navController)
        }
        composable (Screen.Lista) {
            listaUi(Modifier.padding(paddingValues), navController = navController)
        }
        composable (Screen.Tareas) {
            IUTareas(Modifier.padding(paddingValues), navController = navController)
        }
        composable (Screen.Notas) {
            NotasLista(Modifier.padding(paddingValues), navController = navController)
        }
        composable (Screen.Noticias) {
            UINoticias(Modifier.padding(paddingValues), navController = navController)
        }




        //esta es para motrar las notas
        composable(
            route = "${Screen.NoticasCompletas}/{id}/{titulo}/{contenido}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("titulo") { type = NavType.StringType },
                navArgument("contenido") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: -1
            val titulo = backStackEntry.arguments?.getString("titulo") ?: ""
            val contenido = backStackEntry.arguments?.getString("contenido") ?: ""

            UiNotes(Modifier.padding(paddingValues), navController, NotasClass(id, titulo, contenido))
        }

        //esta es para motrar las noticias completas
        composable(
            route = "${Screen.NoticasCompletas}/{title}/{pubDate}/{link}/{content}/{description}/{image_url}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("pubDate") { type = NavType.StringType },
                navArgument("link") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("image_url") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val pubDate = backStackEntry.arguments?.getString("pubDate") ?: ""
            val link = backStackEntry.arguments?.getString("link") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val imageUrl = backStackEntry.arguments?.getString("image_url") ?: ""

            UINoticiaCompleta(
                Modifier.padding(paddingValues),
                navController,
                title = title,
                pubDate = pubDate,
                link = link,
                content = content,
                description = description,
                imageUrl = imageUrl
            )
        }

    }
}




@Composable
fun menu(modifier: Modifier, navController: NavController) {

    LazyColumn (modifier = modifier){
        item {

            Box(modifier = Modifier.padding(16.dp)){
                web(Modifier
                    .fillMaxWidth()
                    .height(100.dp), navController)
            }
            Box(modifier = Modifier.padding(16.dp)){
                Horario(Modifier
                    .fillMaxWidth()
                    .height(100.dp), navController)
            }
            Box(modifier = Modifier.padding(16.dp)){
                lista(Modifier
                    .fillMaxWidth()
                    .height(100.dp), navController)
            }
            Box(modifier = Modifier.padding(16.dp)){
                Tareas(Modifier
                    .fillMaxWidth()
                    .height(100.dp), navController)
            }
            Box(modifier = Modifier.padding(16.dp)){
                Notas(Modifier
                    .fillMaxWidth()
                    .height(100.dp), navController)
            }
            Box(modifier = Modifier.padding(16.dp)){
                Noticias(Modifier
                    .fillMaxWidth()
                    .height(100.dp), navController)
            }
            Box(modifier = Modifier.padding(16.dp)){
                registroDeVersiones(Modifier
                    .fillMaxWidth()
                    .height(100.dp), navController)
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
                text = "🌐Webs",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}

@Composable
fun Horario(modifier: Modifier, navController: NavController) {

    Card (modifier= modifier, onClick = {navController.navigate(Screen.Horario)}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "🕛Horario",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}

@Composable
fun lista(modifier: Modifier, navController: NavController) {

    Card (modifier= modifier, onClick = {navController.navigate(Screen.Lista)}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "📝Lista",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}

@Composable
fun registroDeVersiones(modifier: Modifier, navController: NavController) {

    Card (modifier= modifier, onClick = {navController.navigate(Screen.Veriones)}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "👾Versiones",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}

@Composable
fun Tareas(modifier: Modifier, navController: NavController){
    Card (modifier= modifier, onClick = {navController.navigate(Screen.Tareas)}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "✍️Tareas",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}

@Composable
fun Notas(modifier: Modifier, navController: NavController){
    Card (modifier= modifier, onClick = {navController.navigate(Screen.Notas)}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "🗒Notas",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}

@Composable
fun Noticias(modifier: Modifier, navController: NavController){
    Card (modifier= modifier, onClick = {navController.navigate(Screen.Noticias)}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "📰️Noticias",
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }
    }
}