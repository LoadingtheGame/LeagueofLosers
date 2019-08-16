package com.example.wineryfactory.Controller

import android.content.ContentValues
import android.content.Context
import com.example.wineryfactory.Model.Jogador
import android.widget.Toast
import com.example.wineryfactory.Model.Campeonato
import com.example.wineryfactory.Model.Time

class ButtonFuncoesSQL (context: Context) {
    private val con = context

    fun insertJogador(jogador: Jogador){

        var cv = ContentValues()
        cv.put("nome", jogador.nome)
        cv.put("nick", jogador.nick)
        cv.put("email", jogador.email)
        cv.put("funcao", jogador.funcao)
        cv.put("telefone", jogador.telefone)

        var result = Database(con).writableDatabase.insert("jogador", null, cv)

        if (result == -1.toLong()){
            Toast.makeText(con, "Erro", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(con, "Sucesso", Toast.LENGTH_SHORT).show()
        }
    }

    fun insertCampeonato(campeonato: Campeonato){

        var cp = ContentValues()
        cp.put("nome", campeonato.nome)
        cp.put("descricao", campeonato.descricao)
        cp.put("regras", campeonato.regras)
        cp.put("inicio", campeonato.inicio)
        cp.put("fim", campeonato.fim)

        var vai = Database(con).writableDatabase.insert("campeonato", null, cp)

        if (vai == -1.toLong()){
            Toast.makeText(con, "Erro", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(con, "Sucesso", Toast.LENGTH_SHORT).show()
        }
    }

    fun insertTime(time: Time){

        var cv = ContentValues()
        cv.put("nome", time.nome)

        var result = Database(con).writableDatabase.insert("time", null, cv)

        if (result == -1.toLong()){
            Toast.makeText(con, "Erro", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(con, "Sucesso", Toast.LENGTH_SHORT).show()
        }
    }

    fun buscaJogador(): MutableList<Jogador> {
        var result = Database(con).readableDatabase.rawQuery("select * from jogador", null)

        var list: MutableList<Jogador> = ArrayList()
        while (result.moveToNext()) {
            var jogador = Jogador(result.getString(1), result.getString(2)
                , result.getString(3).toString(), result.getString(4), result.getString(5))
            list.add(jogador)
        }
        return list
    }
}