package com.example.wineryfactory.View

import android.app.DatePickerDialog
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Model.Campeonato
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.activity_cadastrar__campeonato.*
import java.util.*

class Cadastrar_Campeonato : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar__campeonato)

        val context = this

        //Caledario
        val c = Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)

        //abrir campo e preencher campo

        edtinicio_Campeonato.setOnClickListener{
            val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                val a = mMonth + 1
                edtinicio_Campeonato.text = "$mDay/$a/$mYear"
            }, ano, mes, dia)

            dpd.show()
        }

        edtfim_Campeonato.setOnClickListener{
            val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                val a = mMonth + 1
                edtfim_Campeonato.text = "$mDay/$a/$mYear"
            }, ano, mes, dia)

            dpd.show()
        }

        btnCriar_Campeonato.setOnClickListener {
            if (edtNome_Campeonato.text.toString().length > 0 &&
                    edtRegras_Campeonato.text.toString().length > 0){
                var dataInicio = edtinicio_Campeonato.text
                var dataFim = edtfim_Campeonato.text

                var campeonato = Campeonato(edtNome_Campeonato.text.toString(), edtDescricao_Campeonato.text.toString(),
                    edtRegras_Campeonato.text.toString(), dataInicio.toString(), dataFim.toString())
                var bd = ButtonFuncoesSQL(context)

                bd.insertCampeonato(campeonato)

                edtNome_Campeonato.setText("")
                edtDescricao_Campeonato.setText("")
                edtRegras_Campeonato.setText("")
                edtinicio_Campeonato.setText("dd/mm/aaaa")
                edtfim_Campeonato.setText("dd/mm/aaaa")
            }
        }
    }
}
