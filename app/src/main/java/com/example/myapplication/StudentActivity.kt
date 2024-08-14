package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val studentName = findViewById<EditText>(R.id.student_name)
        val note1 = findViewById<EditText>(R.id.note1)
        val note2 = findViewById<EditText>(R.id.note2)
        val note3 = findViewById<EditText>(R.id.note3)
        val note4 = findViewById<EditText>(R.id.note4)
        val note5 = findViewById<EditText>(R.id.note5)
        val buttonCalculate = findViewById<Button>(R.id.button_calculate)
        val textResult = findViewById<TextView>(R.id.text_result)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)

        // Configuración del botón para calcular el promedio
        buttonCalculate.setOnClickListener {
            val name = studentName.text.toString().trim()
            val grades = listOf(
                note1.text.toString().toFloatOrNull(),
                note2.text.toString().toFloatOrNull(),
                note3.text.toString().toFloatOrNull(),
                note4.text.toString().toFloatOrNull(),
                note5.text.toString().toFloatOrNull()
            )

            // Validación
            if (name.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese el nombre del estudiante", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validación de que todas las notas sean válidas y estén en el rango de 0 a 10
            if (grades.all { it != null && it in 0f..10f }) {
                val student = Student(name, grades.filterNotNull())
                val average = student.calculateAverage()

                // Mostrar el resultado del promedio en la interfaz
                textResult.text = student.getResultText(average)
                textResult.setTextColor(student.getResultColor(average))
            } else {
                Toast.makeText(this, "Por favor, ingrese todas las notas válidas entre 0 y 10", Toast.LENGTH_SHORT).show()
            }
        }
        // Configuración del menú de navegación
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_calculator -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_average -> {
                    // Permanecer en la actividad de calcular el promedio
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
