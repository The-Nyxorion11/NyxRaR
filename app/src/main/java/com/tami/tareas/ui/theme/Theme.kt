package com.tami.tareas.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color // Importa Color para usarlo directamente si es necesario

// --- IMPORTA TUS COLORES PERSONALIZADOS ---
// Asegúrate de que la ruta de importación sea correcta si tus colores están en un paquete diferente.
// Por ejemplo, si están en 'com.tami.tareas.View.Colors', las importaciones serían:
import com.tami.tareas.View.Colors.DeepMidnightBlue
import com.tami.tareas.View.Colors.AbyssalTwilight
import com.tami.tareas.View.Colors.TwilightIndigo
import com.tami.tareas.View.Colors.FadedAmethyst
import com.tami.tareas.View.Colors.MutedOffWhite
import com.tami.tareas.View.Colors.DeepSlateBlue


private val DarkColorScheme = darkColorScheme(
    // Colores principales de la marca (para elementos interactivos y de énfasis)
    primary = TwilightIndigo,           // Tu color de acento principal (#272D54)
    onPrimary = MutedOffWhite,          // Color del texto/icono que va SOBRE 'primary'

    // Colores de fondo principal de la aplicación
    background = DeepMidnightBlue,      // ¡Tu color de fondo más oscuro (#070A18)!
    onBackground = MutedOffWhite,       // Color del texto/icono que va SOBRE 'background'

    // Colores para superficies elevadas (tarjetas, diálogos, Top/Bottom App Bars)
    surface = AbyssalTwilight,          // Tu color de superficie (#14172B)
    onSurface = MutedOffWhite,          // Color del texto/icono que va SOBRE 'surface'

    // Colores secundarios y terciarios (para énfasis complementario o contrastante)
    // Puedes usar tus otros colores aquí para dar más variedad
    secondary = FadedAmethyst,          // Un morado apagado para énfasis secundario
    onSecondary = MutedOffWhite,        // Texto/Iconos que van SOBRE 'secondary'
    tertiary = DeepSlateBlue,           // Un azul grisáceo oscuro para énfasis terciario
    onTertiary = MutedOffWhite,         // Texto/Iconos que van SOBRE 'tertiary'

    // Variantes de superficie (si necesitas más distinción entre superficies)
    surfaceVariant = FadedAmethyst,     // Puedes usar FadedAmethyst o AbyssalTwilight aquí
    onSurfaceVariant = DeepSlateBlue,   // Texto/Iconos que van SOBRE 'surfaceVariant'

    // Colores de error (importante para mensajes de error)
    error = Color(0xFFCF6679),          // Un rojo oscuro estándar para errores
    onError = Color.Black,              // Contenido sobre el color de error
    errorContainer = Color(0xFFB00020), // Contenedor de error
    onErrorContainer = Color.White      // Contenido sobre el contenedor de error
)

// --- ESQUEMA DE COLORES CLARO (PARA CUMPLIR CON LA FIRMA, PERO NO SE USARÁ SI darkTheme ES TRUE) ---
// Si tu app solo va a ser oscura, puedes copiar los valores de DarkColorScheme aquí,
// o simplemente dejar los predeterminados si siempre fuerzas `darkTheme = true`.
private val LightColorScheme = lightColorScheme(
    primary = TwilightIndigo,
    onPrimary = MutedOffWhite,
    background = DeepMidnightBlue,
    onBackground = MutedOffWhite,
    surface = AbyssalTwilight,
    onSurface = MutedOffWhite,
    secondary = FadedAmethyst,
    onSecondary = MutedOffWhite,
    tertiary = DeepSlateBlue,
    onTertiary = MutedOffWhite,
    surfaceVariant = FadedAmethyst,
    onSurfaceVariant = DeepSlateBlue,
    error = Color(0xFFCF6679),
    onError = Color.Black,
    errorContainer = Color(0xFFB00020),
    onErrorContainer = Color.White
)

@Composable
fun TareasTheme(
    // --- FORZAR MODO OSCURO ---
    darkTheme: Boolean = true, // <<-- ¡CAMBIADO A 'true' para que siempre sea oscuro!
    // --- DESACTIVAR COLOR DINÁMICO ---
    dynamicColor: Boolean = false, // <<-- ¡CAMBIADO A 'false' para usar tus colores!
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        // Esta condición ahora será 'false' debido a 'dynamicColor = false',
        // por lo que siempre se usará tu 'DarkColorScheme'.
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme // <<-- ¡Este es el esquema que se utilizará!
        else -> DarkColorScheme // <<-- Si 'darkTheme' fuera 'false', también usaría DarkColorScheme.
        //     (Esto es redundante si darkTheme=true siempre, pero no hace daño)
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Asegúrate de que 'Typography' esté definida en este archivo o importada.
        content = content
    )
}
