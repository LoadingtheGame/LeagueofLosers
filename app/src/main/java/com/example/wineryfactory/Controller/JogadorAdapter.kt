package com.example.wineryfactory.Controller

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wineryfactory.Model.Jogador
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.jogador_item.view.*

class JogadorAdapter(private val context: Context, private var jogadorList: MutableList<Jogador>):
    RecyclerView.Adapter<JogadorAdapter.JogadorViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogadorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.jogador_item, parent, false)
        return JogadorViewHolder(view)
    }

    override fun getItemCount() = jogadorList.size

    override fun onBindViewHolder(holder: JogadorViewHolder, position: Int) {
        holder.bindView(jogadorList[position])
    }

    class JogadorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewNome = itemView.textViewNome
        val textViewEmail = itemView.textViewEmail
        val textViewTelefone = itemView.textViewTelefone
        val textViewNick = itemView.textViewNick
        val textViewFuncao = itemView.textViewFuncao

        fun bindView(jogador: Jogador) {
            textViewNome.text = jogador.nome
            textViewEmail.text = jogador.email
            textViewTelefone.text = jogador.telefone
            textViewNick.text = jogador.nick
            textViewFuncao.text = jogador.funcao
        }
    }
}