package com.example.miformacionctma.domain

object ReglasActividad {

    // Devuelve todos los errores encontrados
    fun validarActividad(actividad: ActividadFormativa): List<String> {
        val errores = mutableListOf<String>()

        if (actividad.titulo.isBlank()) {
            errores.add("El título es obligatorio.")
        }

        if (actividad.progreso !in 0..100) {
            errores.add("El progreso debe estar entre 0 y 100.")
        }

        return errores
    }

    // Pendiente, En proceso, Completada o Vencida
    fun estadoActividad(actividad: ActividadFormativa): String =
        when {
            actividad.progreso >= 100 -> "Completada"
            actividad.diasRestantes < 0 -> "Vencida"
            actividad.progreso > 0 -> "En proceso"
            else -> "Pendiente"
        }

    // Actividades no completadas con dos días o menos
    fun actividadesUrgentes(
        actividades: List<ActividadFormativa>
    ): List<ActividadFormativa> =
        actividades.filter {
            it.progreso < 100 && it.diasRestantes in 0..2
        }

    // Promedio de progreso (0 si la lista está vacía)
    fun promedioProgreso(
        actividades: List<ActividadFormativa>
    ): Double =
        if (actividades.isEmpty()) 0.0
        else actividades.map { it.progreso }.average()

    // Busca ignorando mayúsculas/minúsculas y espacios
    fun buscarPorTitulo(
        actividades: List<ActividadFormativa>,
        texto: String
    ): List<ActividadFormativa> {
        val busqueda = texto.trim().lowercase()

        return actividades.filter {
            it.titulo.trim().lowercase().contains(busqueda)
        }
    }
}