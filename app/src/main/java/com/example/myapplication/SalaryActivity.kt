package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class SalaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salary)

        // Referencias a los elementos de la interfaz de usuario
        val nameEditText = findViewById<EditText>(R.id.etNombre)
        val salaryEditText = findViewById<EditText>(R.id.etSalarioBase)
        val calculateButton = findViewById<Button>(R.id.btnCalcular)

        // Referencias a los TextViews que muestran los resultados
        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvNombreMonto = findViewById<TextView>(R.id.tvNombreMonto)
        val tvSalarioBase = findViewById<TextView>(R.id.tvSalarioBase)
        val tvSalarioBaseMonto = findViewById<TextView>(R.id.tvSalarioBaseMonto)
        val tvAFP = findViewById<TextView>(R.id.tvAFP)
        val tvAFPMonto = findViewById<TextView>(R.id.tvAFPMonto)
        val tvISSS = findViewById<TextView>(R.id.tvISSS)
        val tvISSSMonto = findViewById<TextView>(R.id.tvISSSMonto)
        val tvRenta = findViewById<TextView>(R.id.tvRenta)
        val tvRentaMonto = findViewById<TextView>(R.id.tvRentaMonto)
        val tvSalarioNeto = findViewById<TextView>(R.id.tvSalarioNeto)
        val tvSalarioNetoMonto = findViewById<TextView>(R.id.tvSalarioNetoMonto)

        calculateButton.setOnClickListener {
            // Obtención y validación de datos ingresados por el usuario
            val name = nameEditText.text.toString().trim()
            val salary = salaryEditText.text.toString().toFloatOrNull()

            if (name.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese el nombre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (salary != null && salary >= 0) {
                val empleado = Empleado(name, salary)
                val renta = empleado.calcularRenta()
                val afp = salary * 0.0725f
                val isss = salary * 0.03f
                val salarioNeto = empleado.calcularSalarioNeto()

                tvNombre.text = "Nombre:"
                tvNombreMonto.text = name
                tvSalarioBase.text = "Salario Base:"
                tvSalarioBaseMonto.text = "$salary"
                tvAFP.text = "AFP:"
                tvAFPMonto.text = "$afp"
                tvISSS.text = "ISSS:"
                tvISSSMonto.text = "$isss"
                tvRenta.text = "Renta:"
                tvRentaMonto.text = "$renta"
                tvSalarioNeto.text = "Salario Neto:"
                tvSalarioNetoMonto.text = "$salarioNeto"
            } else {
                Toast.makeText(this, "Por favor, ingrese un salario válido", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuración del menú de navegación
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_calculator -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_average -> {
                    val intent = Intent(this, StudentActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_discount -> {
                    // Actividad actual del salario
                    true
                }
                else -> false
            }
        }
    }
}
