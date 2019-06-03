package com.emma.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emma.myapplication.R
import com.emma.myapplication.entities.Game

abstract class GameAdapter internal constructor(context: Context):RecyclerView.Adapter<GameAdapter.GameViewHolder>(){
    private var inflater = LayoutInflater.from(context)
    private var games = emptyList<Game>()

    abstract fun setClickListenerToGame(hodlder: GameViewHolder, game:Game)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView= inflater.inflate(R.layout.fragment_game,parent,false)
        return GameViewHolder(itemView)
    }
    override fun getItemCount()=games.size
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val actualGame = games[position]

        setClickListenerToGame(holder,actualGame)
        holder.home.text = actualGame.home
        holder.visitor.text = actualGame.visitor
        holder.winner.text = actualGame.winner

    }

    internal fun setGames(partidos:List<Game>)
    {
        this.games = games
        notifyDataSetChanged()
    }


    inner class GameViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val home: TextView = itemView.home
        val visitor: TextView = itemView.visitor
        val winner: TextView = itemView.winner
    }

}
