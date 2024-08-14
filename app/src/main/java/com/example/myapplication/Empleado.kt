package com.example.myapplication

class Empleado(
    val nombre: String,
    val salarioBase: Float
) {

    //Declaracion de los porcentajes para los descuentos
    private val AFP = 0.0725f
    private val ISSS = 0.03f

    // Método para calcular la renta según el salario base
    fun calcularRenta(): Float {
        return when {
            salarioBase <= 472.00f -> 0f
            salarioBase <= 895.24f -> 17.67f
            salarioBase <= 2038.10f -> 60.00f
            else -> 288.57f
        }
    }

    // Método para calcular el salario neto descontando AFP, ISSS y Renta
    fun calcularSalarioNeto(): Float {
        val renta = calcularRenta()
        val afp = salarioBase * AFP
        val isss = salarioBase * ISSS
        return salarioBase - renta - afp - isss
    }

    fun mostrarDetalleDescuentos(): String {
        val renta = calcularRenta()
        val afp = salarioBase * AFP
        val isss = salarioBase * ISSS
        val salarioNeto = calcularSalarioNeto()

        // Devuelve un string con los detalles formateados
        return """
            Nombre: $nombre
            Salario Base: ${"%.2f".format(salarioBase)}
            AFP: ${"%.2f".format(afp)}
            ISSS: ${"%.2f".format(isss)}
            Renta: ${"%.2f".format(renta)}
            Salario Neto: ${"%.2f".format(salarioNeto)}
        """.trimIndent()
    }
}