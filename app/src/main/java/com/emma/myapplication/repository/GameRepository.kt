package com.emma.myapplication.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.emma.myapplication.dao.GameDao
import com.emma.myapplication.entities.Game

class GameRepository(private val gameDao: GameDao) {

    fun getAll():LiveData<List<Game>> = gameDao.getAll()
    fun getGame(idGame: Int): LiveData<Game> = gameDao.getGame(idGame)

    @WorkerThread
    suspend fun insert(game: Game) = gameDao.insert(game)


}