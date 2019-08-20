package com.example.wineryfactory.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Controller.JogadorAdapter
import com.example.wineryfactory.Controller.TimeAdapter
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.activity_adicionar__time.*

class Adicionar_Time : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar__time)

        var context = this


        btn_NovoTime.setOnClickListener {
            val Intent = Intent(this, Cadastrar_Time::class.java)
        }



        var timeAdapter = TimeAdapter(context, ButtonFuncoesSQL(context).buscaTime() )
        var recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewAdicionarTime)
        recyclerView.adapter = timeAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.smoothScrollToPosition(timeAdapter.itemCount)
    }
}
