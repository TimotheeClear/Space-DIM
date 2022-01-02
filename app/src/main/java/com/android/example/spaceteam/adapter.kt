package com.android.example.spaceteam

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PlayersAdapter(val PlayerDisplay : Array<Players>, val listener: (Players) -> Unit)
    : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val ma_ligne = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(ma_ligne)
    }

    override fun getItemCount(): Int = PlayerDisplay.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("XXX","onBindViewHolder")
        holder.bind(PlayerDisplay[position],listener)
    }

    class ViewHolder(val elementDeListe : View) : RecyclerView.ViewHolder(elementDeListe)
    {
        fun bind(players: Players, listener: (Players) -> Unit) = with(itemView)
        {
            Log.i("XXX","bind")
            findViewById<TextView>(R.id.player_name).text = players.pseudo
            val player_state = findViewById<TextView>(R.id.player_state)
            if (players.state){
                player_state.text = "Prêt"
                player_state.setTextColor(ContextCompat.getColorStateList(context,R.color.green))
            } else {
                player_state.text = "Pas prêt"
                player_state.setTextColor(ContextCompat.getColorStateList(context,R.color.red))
            }
            setOnClickListener { listener(players) }
        }
    }

}