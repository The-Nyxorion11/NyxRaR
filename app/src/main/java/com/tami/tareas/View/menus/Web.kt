package com.tami.tareas.View.menus

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tami.tareas.View.Screen

@Composable
fun webApps(navController: NavHostController) {
    educaCity(Modifier.fillMaxWidth())
}

@Composable
fun educaCity(modifier: Modifier) {
    Card (modifier= modifier, onClick = {}){
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Image(painter = painterResource(id = R.drawable.), contentDescription = "EducaCity")
            Text(
                text = "Webs",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
