package com.example.wineryfactory.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Model.Campeonato
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.activity_cadastrar__campeonato.*

class Cadastrar_Campeonato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar__campeonato)

        val context = this

        btnCriar_Campeonato.setOnClickListener {
            if (edtNome_Campeonato.text.toString().length > 0 &&
                    edtRegras_Campeonato.text.toString().length > 0){
                var dataInicio = edtInicio_Campeonato.unmaskedText
                var dataFim = edtFim_Campeonato.unmaskedText

                var campeonato = Campeonato(edtNome_Campeonato.text.toString(), edtDescricao_Campeonato.text.toString(),
                    edtRegras_Campeonato.text.toString(), dataInicio.toString(), dataFim.toString())
                var bd = ButtonFuncoesSQL(context)

                bd.insertCampeonato(campeonato)

                edtNome_Campeonato.setText("")
                edtDescricao_Campeonato.setText("")
                edtRegras_Campeonato.setText("")
                edtInicio_Campeonato.setMaskedText("")
                edtFim_Campeonato.setMaskedText("")
            }
        }
    }

    override fun onBackPressed() {
        finish()
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}
