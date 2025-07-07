package com.tami.tareas.View.menus

//importaciones para los links
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import com.tami.tareas.R
import androidx.core.net.toUri

val educaCityLink: String = "https://www.educa.city"

@Composable
fun webApps(modifier: Modifier, navController: NavHostController) {
    LazyColumn (modifier = modifier) {
        item{
            Box(modifier = Modifier.padding(16.dp)){
                educaCity(Modifier.fillMaxWidth())
            }
        }
    }
}


@SuppressLint("QueryPermissionsNeeded")
@Composable
fun educaCity(modifier: Modifier) {
    //para el context del lanzador a la pagina web
    val context = LocalContext.current

    Card (modifier= modifier, onClick = {
        //codigo para el link
        val webPage = educaCityLink.toUri()

        val intent = Intent(Intent.ACTION_VIEW, webPage)

        //buena practica para evitar crasheos si no tengo un navegador
        if (intent.resolveActivity(context.packageManager) != null){
            try {
                context.startActivity(intent)
            }catch (e : Exception){
                Log.e("ERROR_ABRIR_WEB", "Error al intentar ebrir la web: ${e.message}", e)
                //avisa a el usuario que hubo un error
                Toast.makeText(context, "No se pudo abrir la web: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }else{

            Log.e("ERROR_WEB", "Hay un error al lanzar el navegador no se encontro la url de la web")
            Toast.makeText(
                context,
                "No se encontró una aplicación para abrir la web. Por favor, instala un navegador.",
                Toast.LENGTH_LONG
            ).show()
        }

    }){
        Row (
            Modifier.fillMaxWidth().height(100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Image(painter = painterResource(id = R.drawable.educacity), contentDescription = "EducaCity", modifier= Modifier.width(50.dp).height(50.dp))
            Text(
                text = "EducaCity",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
