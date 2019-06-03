package com.emma.myapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emma.myapplication.entities.Game


@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(game:Game):Long

    @Query("SELECT * FROM 'game' ")
    fun getAll(): LiveData<List<Game>>

    @Query("select * from `game` where id=:idGame")
    fun getGame(idGame: Int):LiveData<Game>
}