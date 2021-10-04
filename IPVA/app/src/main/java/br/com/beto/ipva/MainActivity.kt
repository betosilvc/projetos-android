package br.com.beto.ipva

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.beto.ipva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //array para preencher o spinner
        val listaEstados = arrayListOf(
            "Selecione seu estado",
            "Acre","Alagoas","Amapá","Amazonas","Bahia","Ceará","Distrito Federal",
            "Espirito Santo","Goias","Maranhão","Mato Grosso","Mato Grosso do sul", "Minas Gerais",
            "Pará","Paraiba","Paraná","Pernambuco","Piaui", "Rio de Janeiro", "Rio Grande do Norte",
            "Rio Grande do Sul","Rondônia","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins")

        val spinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, listaEstados)
        binding.spnMainEstados.adapter = spinnerAdapter


        binding.btnCalcular.setOnClickListener {

            val estado = binding.spnMainEstados.selectedItem.toString()
            val valorDoCarro = binding.edtMainValor.text.toString()


            if (valorDoCarro.isEmpty() || estado == listaEstados[0]) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else {
                if(estado == listaEstados[24] || estado == listaEstados[8] || estado == listaEstados[26]
                    || estado == listaEstados[15]
                    || estado == listaEstados[1]  || estado == listaEstados[27]) {
                    val valorTotal = valorDoCarro.toFloat() * 0.02
                    binding.txvMainTotal.text= "O valor do IPVA é R$"+"%.2f".format(valorTotal)
                }else if(estado == listaEstados[21] || estado == listaEstados[25] || estado == listaEstados[3]
                    || estado == listaEstados[4] || estado == listaEstados[23] || estado == listaEstados[22]
                    || estado == listaEstados[11] || estado == listaEstados[7]) {
                    val valorTotal = valorDoCarro.toFloat() * 0.03
                    binding.txvMainTotal.text = "O valor do IPVA é R$"+"%.2f".format(valorTotal)
                }else if(estado == listaEstados[2] || estado == listaEstados[17] || estado == listaEstados[20]
                    || estado == listaEstados[6] || estado == listaEstados[18]
                    || estado == listaEstados[10] || estado == listaEstados[5] || estado == listaEstados[14]
                    || estado == listaEstados[12] || estado == listaEstados[9]) {
                val valorTotal = valorDoCarro.toFloat() * 0.025
                    binding.txvMainTotal.text = "O valor do IPVA é R$"+"%.2f".format(valorTotal)
                }else if(estado == listaEstados[19] || estado == listaEstados[13]) {
                    val valorTotal = valorDoCarro.toFloat() * 0.04
                    binding.txvMainTotal.text = "O valor do IPVA é R$"+"%.2f".format(valorTotal)
                }else {
                    val valorTotal = valorDoCarro.toFloat() * 0.035
                    binding.txvMainTotal.text = "O valor do IPVA é R$"+"%.2f".format(valorTotal)

                }

            }
        }
    }
}