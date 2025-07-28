plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
  
}

android {

    namespace = "com.tami.tareas"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.tami.tareas"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    //implementaciones propias
    // --- Dependencias de Androidx Core y Lifecycle ---
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx) // O lifecycle.runtime.compose si es el que necesitas
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.compose) // Para Composable en ciclo de vida
    implementation(libs.androidx.runtime.livedata) // Si estás usando LiveData con Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose) // Para ViewModel con Compose

    // --- Compose BOM (Bill of Materials) ---
    // ¡SOLO UNA VEZ! Preferiblemente sin la versión en el alias si la manejas en libs.versions.toml
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)


    // --- Dependencias básicas de Compose UI y Material ---
    // Usando los alias más comunes/limpios. Asegúrate de que estos alias existan y apunten a las librerías correctas en libs.versions.toml
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.dagger) // Example Dagger version
    ksp(libs.dagger.compiler)

    // --- Navegación de Compose ---
    // ¡SOLO UNA VEZ! Esta es la clave para 'composable'
    implementation(libs.androidx.navigation.compose)

    // --- Dependencias de Testing ---
    debugImplementation(libs.androidx.compose.ui.ui.tooling)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4) // Test para Compose

    // --- Debugging y Herramientas ---
    debugImplementation(libs.androidx.ui.tooling) // Para el preview en el IDE
    debugImplementation(libs.androidx.ui.test.manifest) // Para pruebas de U

    //implementations of room

    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    // ViewModel utilities for Compose
    implementation (libs.androidx.lifecycle.viewmodel.compose.v280)
    // LiveData (if you prefer LiveData over StateFlow)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    // Kotlinx Coroutines (for async operations)
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)
    //ViewModel and lifecycle
    implementation (libs.androidx.lifecycle.viewmodel.ktx.v281)
    implementation (libs.androidx.lifecycle.runtime.ktx.v281)

    //OMG IS THE HILT
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation (libs.androidx.hilt.navigation.compose)



    implementation(libs.kotlin.stdlib)


    implementation(libs.dagger.v2481)
    ksp(libs.dagger.compiler.v2481)

    //apis
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //url imagenes
    implementation(libs.coil.compose)
}