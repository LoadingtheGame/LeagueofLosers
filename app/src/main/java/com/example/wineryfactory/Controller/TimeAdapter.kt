package com.example.wineryfactory.Controller

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wineryfactory.Model.Time
import com.example.wineryfactory.R
import kotlinx.android.synthetic.main.jogador_item.view.*
import kotlinx.android.synthetic.main.time_item.view.*

class TimeAdapter(private val context: Context, private var timeList: MutableList<Time>):
    RecyclerView.Adapter<TimeAdapter.TimeViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.jogador_item, parent, false)
        return TimeViewHolder(view)
    }

    override fun getItemCount() = timeList.size

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        holder.bindView(timeList[position])
    }

    class TimeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewNomeTime = itemView.textViewNomeTime

        fun bindView(time: Time) {
            textViewNomeTime.text = time.nome
        }
    }
}