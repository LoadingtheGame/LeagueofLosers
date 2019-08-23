package com.example.wineryfactory.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wineryfactory.Controller.ButtonFuncoesSQL
import com.example.wineryfactory.Controller.TimeAdapter
import com.example.wineryfactory.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

class tela_times : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.tela_times, container, false)
        recyclerView = v.findViewById(R.id.recyclerViewTimes)
        return v
    }

    fun updateList() {
        var timeAdapter = TimeAdapter(activity!!.applicationContext, ButtonFuncoesSQL(activity!!.applicationContext).buscaTime() )
        recyclerView.adapter = timeAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.smoothScrollToPosition(timeAdapter.itemCount)
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            tela_times().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}
