package br.com.beto.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import br.com.beto.estacaohack.databinding.ActivityMainBinding
import br.com.beto.estacaohack.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //habilitando a execução de code js
        binding.wbvWeb.settings.javaScriptEnabled = true
        //carregar um endereço web
        binding.wbvWeb.loadUrl("https://br.cellep.com/estacaohack/")
        //definindo o webview como cliente web padrão
        binding.wbvWeb.webViewClient = WebViewClient()

    }
}