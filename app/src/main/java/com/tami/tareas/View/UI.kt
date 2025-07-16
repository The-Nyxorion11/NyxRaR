package com.tami.tareas.View


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.tami.tareas.View.Colors.AbyssalTwilight
import com.tami.tareas.View.Colors.DeepMidnightBlue
import com.tami.tareas.ui.theme.TareasTheme



@Preview
@Composable
fun uiresutl(){
    TareasTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column (modifier = Modifier.fillMaxSize().background(DeepMidnightBlue)){
                UI()
            }
        }
    }
}

//UI es donde se hace la ui y se manda a main, result no se toca, solo es para la vista
@Composable
fun UI(){
    uiSistem()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun uiSistem(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = "Menu NyxApp 1.2.0",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                    ) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AbyssalTwilight
                )
            )
        }
    ){paddingValues ->
         appNavigation(paddingValues)
    }
}
