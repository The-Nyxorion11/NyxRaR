package com.tami.tareas.View.menus.Tareas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun IUTareas(modifier: Modifier, navController: NavHostController) {

    Column (modifier){
        lista()
    }
}


@Composable
fun lista() {
    val cardList = remember { mutableStateListOf<String>() }
    var text by rememberSaveable { mutableStateOf("") }

    Column{
        TextField(
            value = text,
            onValueChange = {text = it},
            label = {Text("name")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                if (text.isNotBlank()) {
                    cardList.add(text)
                    text = "" // Limpiar campo
                }
            }
        ) {
            Text(text = "+")
        }


        LazyColumn {
            items(cardList.toList()){item ->
                card(item)

            }
        }
    }
}

@Composable
fun card(item: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = "",
            modifier = Modifier.padding(16.dp)
        )
    }
}

