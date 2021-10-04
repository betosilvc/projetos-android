package br.com.beto.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import br.com.beto.estacaohack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recuperar o email passado pelo Intent
        val email = intent.getStringExtra("INTENT_EMAIL")
        val sharedPref = getSharedPreferences("cadastro $email", Context.MODE_PRIVATE)

        val nome = sharedPref.getString("NOME", "")
        val sobreNome = sharedPref.getString("SOBRENOME", "")
        val continente = sharedPref.getString("CONTINENTE", "")

        binding.txvMainNome.text = "$nome $sobreNome"
        binding.txvMainEmail.text = email
        binding.txvMainContinente.text = continente

        //Botao sair
        binding.btnMainSair.setOnClickListener {
            //criando uma caixa de dialogo
            val alert = AlertDialog.Builder(this)
            // definindo o titulo da caixa de dialogo
            alert.setTitle("Atenção")
            //definindo a mensagem da caixa de dialogo
            alert.setMessage("Deseja Sair?")
            alert.setPositiveButton("SIM"){dialog, which ->
                val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finish()
            }

            alert.setNeutralButton("Não") {dialog, which ->}
            alert.setCancelable(false)
            alert.show()

        }


        //botao site
        binding.btnMainSite.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}