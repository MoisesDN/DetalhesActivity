package com.moisesdias.activityfragment

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    lateinit var btnFechar: Button
    lateinit var textDetalhes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnFechar = findViewById(R.id.btn_fechar)
        textDetalhes = findViewById(R.id.text_filme)

        val bundle = intent.extras
        if (bundle != null) {
            /*val filme = bundle.getString("filme")
            val avaliacoes = bundle.getDouble("avaliacoes")
            val classificacao = bundle.getInt("classificacao")*/

            val filme = if (Build.VERSION.SDK_INT >= 33) {
                bundle.getSerializable("filme", Filme::class.java)
            } else{
                bundle.getSerializable("filme") as Filme
            }
            //val filme = bundle.getSerializable("filme") as Filme


            //val resultado = "filme: ${filme.nome} - avaliacoes: $avaliacoes - classificacao: $classificacao"
            textDetalhes.text = "${filme?.nome} - ${filme?.distribuidor}"
        }

        btnFechar.setOnClickListener {
            finish()
        }
    }
}