package com.example.wineryfactory.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Model.Time
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.activity_cadastrar__jogador.*
import kotlinx.android.synthetic.main.activity_cadastrar__time.*

class Cadastrar_Time : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar__time)

        var context = this

        btnCriar_Time.setOnClickListener {
            if (edtNome_Time.text.toString().length > 0){

                var time = Time(edtNome_Time.text.toString())
                var db = ButtonFuncoesSQL(context)

                db.insertTime(time)

               edtNome_Time.setText("")
            }
        }
    }
}
