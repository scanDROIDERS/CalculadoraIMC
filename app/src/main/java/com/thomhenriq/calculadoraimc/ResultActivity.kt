package com.thomhenriq.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thomhenriq.calculadoraimc.databinding.ActivityMainBinding
import com.thomhenriq.calculadoraimc.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultado = intent.getStringExtra("imc").toString().toDouble()
        var text = binding.imc
        var value = binding.IMCvalue
        when(resultado) {
            in 0.0 .. 15.9  -> {
                text.text = "Magreza Grave"
                value.text = "%.1f".format(resultado)
            }
            in 16.0 .. 16.9 -> {
                text.text = "Magreza Moderada"
                value.text = "%.1f".format(resultado)
            }
            in 17.0 .. 18.5 -> {
                text.text = "Magreza"
                value.text = "%.1f".format(resultado)
            }
            in 18.6 .. 24.9 -> {
                text.text = "Saudavel"
                value.text = "%.1f".format(resultado)
            }
            in 25.0 .. 29.9 -> {
                text.text = "Sobrepeso"
                value.text = "%.1f".format(resultado)
            }
            in 31.1 .. 34.9 -> {
                text.text = "Obesidade I"
                value.text = "%.1f".format(resultado)
            }
            in 35.0 .. 39.9 -> {
                text.text = "Obesidade II"
                value.text = "%.1f".format(resultado)
            }
            else -> {
                if(resultado > 40) {
                    text.text = "Obesidade III"
                    value.text = "%.1f".format(resultado)
                }
            }
        }

        binding.botaoVoltar.setOnClickListener{ voltarMain() }
    }

    private fun voltarMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}