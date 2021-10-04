package br.com.beto.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.beto.estacaohack.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    //int string float boolean
    //variavel referencia a class ActivityLoginBinding
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // quando o botão for clicado, faça...
        binding.btnLoginEntrar.setOnClickListener{

            val email = binding.editLoginEmail.text.toString().trim()
            val senha = binding.editLoginSenha.text.toString().trim()

            if(email.isEmpty()) {
                // vamos atribuir uma mensagem de erro no email
                binding.editLoginEmail.error = "Campo Obrigatório"
                //destacar o componente
                binding.editLoginEmail.requestFocus()

            }else if(senha.isEmpty()) {

                binding.editLoginSenha.error = "Campo Obrigatório"
                binding.editLoginSenha.requestFocus()

            }else{

                    val sharedPref = getSharedPreferences("cadastro $email", Context.MODE_PRIVATE)
                    val emailPrefs = sharedPref.getString("EMAIL", "")
                    val senhaPrefs = sharedPref.getString("SENHA", "")

                if(email == emailPrefs && senha  == senhaPrefs) {
                    //exibindo mesnsagem de sucesso
                    Toast.makeText(this,"Usuário Logado", Toast.LENGTH_LONG).show()
                    //vamos abrir a MainActivity
                    val mIntent = Intent(this, MainActivity::class.java)
                    //passando email por intent
                    mIntent.putExtra("INTENT_EMAIL", email)

                    startActivity(mIntent)

                    finish()
                }else {
                    Toast.makeText(this, "Email ou senha invalidos", Toast.LENGTH_LONG).show()
                }
            }
        }//end Entrar listener

        binding.btnLoginCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
            finish()
        }


    }// end onCreate
}//end class