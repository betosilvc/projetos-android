package br.com.beto.calculadoradeimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.beto.calculadoradeimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainCalcular.setOnClickListener {

            val peso = binding.edtMainPeso.text.toString()
            val altura = binding.edtMainAltura.text.toString()

            val imc = peso.toFloat() / ((altura.toFloat()/100) * (altura.toFloat()/100))
            binding.txvMainResultado.text = imc.toString()

            if (imc < 18.5) {
                var resultado2 = "Abaixo do peso"
                binding.txvMainResultado2.text = resultado2
            }
            else if (imc <= 24.9) {
                var resultado2 = "peso normal"
                binding.txvMainResultado2.text = resultado2
            }
            else if (imc <= 29.9) {
                var resultado2 = "sobrepeso"
                binding.txvMainResultado2.text = resultado2
            }
            else {
                var resultado2 = "Obesidade"
                binding.txvMainResultado2.text = resultado2

            }

        }
    }
}