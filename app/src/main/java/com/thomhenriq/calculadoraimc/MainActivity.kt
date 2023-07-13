package com.thomhenriq.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.thomhenriq.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoCalcular.setOnClickListener{ calcular() }

    }

    private fun calcular() {
        val peso = binding.campoPeso.text.toString().toDoubleOrNull()
        val altura = binding.campoAltura.text.toString().toDoubleOrNull()
        var imc: Double

        if(peso == null || altura == null) {
            Toast.makeText(this, "Por favor preencha todos os campos.", Toast.LENGTH_LONG).show()
        } else {
            imc = peso/altura

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("imc", imc.toString())

            startActivity(intent)
        }
    }
}