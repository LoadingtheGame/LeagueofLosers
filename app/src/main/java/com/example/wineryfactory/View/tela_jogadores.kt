package com.example.wineryfactory.View

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Controller.JogadorAdapter
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.activity_cadastrar__jogador.*
import kotlinx.android.synthetic.main.tela_jogadores.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

class tela_jogadores : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.tela_jogadores, container, false)
        var jogadorAdapter = JogadorAdapter(
            activity!!.applicationContext,
            ButtonFuncoesSQL(activity!!.applicationContext).buscaJogador()
        )
        recyclerView = view.findViewById(R.id.recyclerViewJogador)
        recyclerView.adapter = jogadorAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        recyclerView.smoothScrollToPosition(jogadorAdapter.itemCount)

        return view
    }

    fun updateList() {
        var jogadorAdapter = JogadorAdapter(
            activity!!.applicationContext,
            ButtonFuncoesSQL(activity!!.applicationContext).buscaJogador()
        )
        recyclerView.adapter = jogadorAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        recyclerView.smoothScrollToPosition(jogadorAdapter.itemCount)
    }

    @SuppressLint("MissingSuperCall")
    override fun onResume() {
        updateList()
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            tela_jogadores().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}
