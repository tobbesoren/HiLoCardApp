package com.example.hilocardapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HiScoreRecyclerAdapter(val context : Context, val hiScores : List<HiScoreItem>) : RecyclerView.Adapter<HiScoreRecyclerAdapter.ViewHolder>(){

    var layoutInflater = LayoutInflater.from(context)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hiScoreItem = hiScores[position]

        holder.hiScoreTextView.text = hiScoreItem.score.toString()
        holder.rankTextView.text = "No. " + (position + 1).toString() +":"

    }

    override fun getItemCount(): Int {
        return hiScores.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val hiScoreTextView = itemView.findViewById<TextView>(R.id.hiScoreTextView)
        val rankTextView = itemView.findViewById<TextView>(R.id.rankTextView)

    }
}