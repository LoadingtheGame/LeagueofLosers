package com.example.wineryfactory.View

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Model.Campeonato
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.activity_cadastrar__campeonato.*
import java.util.*

class Cadastrar_Campeonato : AppCompatActivity() {

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
            edtInicio_Campeonato.setText("         ")
            val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                edtinicio_Campeonato.setText("$mDay/$mMonth/$mYear")
            }, ano, mes, dia)

            dpd.show()
        }

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
}
