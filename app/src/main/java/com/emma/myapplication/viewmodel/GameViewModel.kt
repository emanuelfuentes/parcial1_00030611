package com.emma.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.emma.myapplication.database.GameDataBase
import com.emma.myapplication.entities.Game
import com.emma.myapplication.repository.GameRepository

class GameViewModel(val app:Application):AndroidViewModel(app) {
private val gameRepositorie: GameRepository
    val allGames: LiveData<List<Game>>
    var game:LiveData<Game>?=null
    init {
        val gameDao = GameDataBase.getInstance(app, viewModelScope).gameDao()
        gameRepositorie = GameRepository(gameDao)
        allGames= gameRepositorie.getAll()
    }
    fun getAll() = gameRepositorie.getAll()

}