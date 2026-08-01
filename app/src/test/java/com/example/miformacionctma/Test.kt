package com.example.miformacionctma

import com.example.miformacionctma.domain.ActividadFormativa
import com.example.miformacionctma.domain.Prioridad
import com.example.miformacionctma.domain.ReglasActividad
import junit.framework.TestCase.assertTrue
import org.junit.Test

class Test {
    @Test
    fun probarValidacion() {

        val actividad = ActividadFormativa(
            id = 1,
            titulo = "   ",
            descripcion = null,
            progreso = 50,
            diasRestantes = 5,
            prioridad = Prioridad.MEDIA
        )


        val errores = ReglasActividad.validarActividad(actividad)

        println(errores)

        assertTrue(errores.isNotEmpty())
    }

}