package com.example.wineryfactory.View
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Model.Jogador
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.activity_cadastrar__jogador.*
import kotlinx.android.synthetic.main.activity_cadastrar__jogador.edtTelefone


class Cadastrar_Jogador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar__jogador)

        val context = this

        btnCriar_Jogador.setOnClickListener {
            if (edtFuncao.text.toString().length > 0 &&
                    edtTelefone.text.toString().length > 0){
                var telefone = edtTelefone.unmaskedText
                var jogador = Jogador(edtNome.text.toString(),edtNick.text.toString(),edtEmail.text.toString(),
                    edtFuncao.text.toString(), telefone.toString())
                var db = ButtonFuncoesSQL(context)

                db.insertJogador(jogador)

                edtNome.setText("")
                edtNick.setText("")
                edtEmail.setText("")
                edtFuncao.setText("")
                edtTelefone.setMaskedText("")
            }
        }
    }

    override fun onBackPressed() {
        finish()
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}
