package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    // Inicializa una instancia a la clase operation
    private val operation = Operation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra las vistas en el diseño
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDivide = findViewById<Button>(R.id.button_divide)
        val textResult = findViewById<TextView>(R.id.text_result)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)


        buttonAdd.setOnClickListener {
            val num1 = number1.text.toString().toFloatOrNull()// Convierte el texto a Float
            val num2 = number2.text.toString().toFloatOrNull()

            if (num1 != null && num2 != null) {
                val result = operation.add(num1, num2)
                textResult.text = getString(R.string.result) + " " + result.toString()
            } else {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura el listener para el botón de resta
        buttonSubtract.setOnClickListener {
            val num1 = number1.text.toString().toFloatOrNull()
            val num2 = number2.text.toString().toFloatOrNull()

            if (num1 != null && num2 != null) {
                val result = operation.subtract(num1, num2)// Llama a la función de resta
                textResult.text = getString(R.string.result) + " " + result.toString()
            } else {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_SHORT).show()
            }
        }

        buttonMultiply.setOnClickListener {
            val num1 = number1.text.toString().toFloatOrNull()
            val num2 = number2.text.toString().toFloatOrNull()

            if (num1 != null && num2 != null) {
                val result = operation.multiply(num1, num2)
                textResult.text = getString(R.string.result) + " " + result.toString()
            } else {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_SHORT).show()
            }
        }

        buttonDivide.setOnClickListener {
            val num1 = number1.text.toString().toFloatOrNull()
            val num2 = number2.text.toString().toFloatOrNull()

            if (num1 != null && num2 != null) {
                val result = operation.divide(num1, num2)
                if (result != null) {
                    textResult.text = getString(R.string.result) + " " + result.toString()
                } else {
                    Toast.makeText(this, "La división por cero no es permitida", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuración del menú de navegación
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_calculator -> {
                    // Actividad principal de la calculadora
                    true
                }
                R.id.nav_average -> {
                    val intent = Intent(this, StudentActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_discount -> {
                    val intent = Intent(this, SalaryActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
