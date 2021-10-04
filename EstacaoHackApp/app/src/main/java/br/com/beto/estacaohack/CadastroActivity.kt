package br.com.beto.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.beto.estacaohack.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    //variavel de referencia a classe ActivityCadastroBinding
    private lateinit var binding: ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root) //renderizando a xml da Activity Cadastro

        //Criando uma lista de opções para o spinner
        val listaContinentes = arrayListOf(
            "Continente",
            "Africa",
            "America",
            "Antartida",
            "Asia",
            "Europa",
            "Oceania")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaContinentes)
        binding.spnCadastroContinente.adapter = spinnerAdapter

        //Quando clicar no botao cadastrar, faça...
        binding.btnCadastroCadastrar.setOnClickListener {

            val nome = binding.editCadastroNome.text.toString().trim()
            val sobreNome = binding.editCadastroSobrenome.text.toString().trim()
            val email = binding.editCadastroEmail.text.toString().trim()
            val senha = binding.editCadastroSenha.text.toString().trim()
            val continente = binding.spnCadastroContinente.selectedItem.toString().trim()

            //Verificar se os campos foram preenchidos
            if(nome.isEmpty() || sobreNome.isEmpty() || email.isEmpty() || senha.isEmpty() ||
                    continente == listaContinentes[0]) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()

            }else {

                //getSharedPreferences (nome do arquivo)
                val sharedPref = getSharedPreferences("cadastro $email", Context.MODE_PRIVATE)

                // passamos a val sharedpref com o metodo edit
                val editPref = sharedPref.edit()

                //putString ("chave, key", valor)
                editPref.putString("NOME", nome)
                editPref.putString("SOBRENOME", sobreNome)
                editPref.putString("EMAIL", email)
                editPref.putString("SENHA", senha)
                editPref.putString("CONTINENTE", continente)

                editPref.apply()

                //Load MainActivity
                val mIntent = Intent(this, MainActivity::class.java)

                //vamos utilizar  o email para identificar qual arquivo xml criado
                mIntent.putExtra("INTENT_EMAIL", email)

                startActivity(mIntent)
                finish()

            }


        }
    }
}