package com.example.myapplication

class Operation {
    // Método para sumar dos números
    fun add(num1: Float, num2: Float): Float {
        return num1 + num2
    }

    // Método para restar dos números
    fun subtract(num1: Float, num2: Float): Float {
        return num1 - num2
    }

    // Método para multiplicar dos números
    fun multiply(num1: Float, num2: Float): Float {
        return num1 * num2
    }

    // Método para dividir dos números
    fun divide(num1: Float, num2: Float): Float? {
        return if (num2 != 0f) {
            num1 / num2
        } else {
            null // División por cero no permitida
        }
    }
}
