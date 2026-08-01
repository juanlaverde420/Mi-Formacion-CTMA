package com.example.miformacionctma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miformacionctma.ui.theme.MiFormacionCTMATheme
import com.example.miformacionctma.domain.ActividadFormativa
import com.example.miformacionctma.domain.Prioridad
import com.example.miformacionctma.domain.ReglasActividad

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val actividades = listOf(
            ActividadFormativa(
                id = 1,
                titulo = "",
                descripcion = "Aprender variables y funciones",
                progreso = 100,
                diasRestantes = -2,
                prioridad = Prioridad.ALTA
            ),
            ActividadFormativa(
                id = 2,
                titulo = "Android Studio",
                descripcion = "Instalar Android Studio",
                progreso = 60,
                diasRestantes = 1,
                prioridad = Prioridad.MEDIA
            ),
            ActividadFormativa(
                id = 3,
                titulo = "Jetpack Compose",
                descripcion = "Crear la primera pantalla",
                progreso = 0,
                diasRestantes = 5,
                prioridad = Prioridad.BAJA
            )
        )
        val promedio = ReglasActividad.promedioProgreso(actividades)

        val urgentes = ReglasActividad.actividadesUrgentes(actividades)

        val resumen = """
        Total de actividades: ${actividades.size}
        Promedio de progreso: ${"%.1f".format(promedio)}%
        Actividades urgentes: ${urgentes.size}
        """.trimIndent()
        setContent {
            MiFormacionCTMATheme {
                PantallaInicio(resumen = resumen)
            }
        }
    }
}

@Composable
fun PantallaInicio(
    nombre: String = "Aprendiz",
    resumen: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mi Formación CTMA",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Hola, $nombre")
        Text(text = "Aquí organizarás actividades y evidencias.")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = resumen)
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    MiFormacionCTMATheme {
        PantallaInicio(
            resumen = "Resumen de ejemplo"
        )
    }
}