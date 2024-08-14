package com.example.myapplication

import android.graphics.Color

class Student(private val name: String, private val grades: List<Float>) {

    // Calcula el promedio ponderado de las notas
    fun calculateAverage(): Float {
        return (grades[0] * 0.15f) + (grades[1] * 0.15f) + (grades[2] * 0.20f) +
                (grades[3] * 0.25f) + (grades[4] * 0.25f)
    }

    // Genera el texto de resultado basado en el promedio
    fun getResultText(average: Float): String {
        val formattedAverage = "%.2f".format(average) // muestra solo dos decimales
        return "Estudiante: $name\nNota Final: $formattedAverage\n" + if (average >= 6f) {
            "¡Aprobado!"
        } else {
            "Reprobado"
        }
    }

    // Devuelve el color del texto basado en el promedio
    fun getResultColor(average: Float): Int {
        return if (average >= 6f) Color.parseColor("#004d00") else Color.RED
    }
}