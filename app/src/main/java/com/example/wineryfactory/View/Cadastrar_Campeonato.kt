package com.example.wineryfactory.View

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Model.Campeonato
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.activity_cadastrar__campeonato.*
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class Cadastrar_Campeonato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar__campeonato)

        val context = this

        val c:Calendar = Calendar.getInstance()
        var datePick: DatePickerDialog? = null

        edtInicio_Campeonato.setOnClickListener {

            var dia:Int = c.get(Calendar.DAY_OF_MONTH)
            var mes:Int = c.get(Calendar.MONTH)
            var ano: Int = c.get(Calendar.YEAR)
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
