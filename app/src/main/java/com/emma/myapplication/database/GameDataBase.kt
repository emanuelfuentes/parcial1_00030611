package com.emma.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.emma.myapplication.dao.GameDao
import com.emma.myapplication.entities.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Game::class],version = 1,exportSchema = false)
abstract class GameDataBase:RoomDatabase() {
abstract fun gameDao():GameDao
    companion object {
@Volatile
private var INSTANCE: GameDataBase? = null
        fun getInstance(appContext: Context, scope: CoroutineScope):GameDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null)return tempInstance
            synchronized(this)
            {
                val instance = Room
                    .databaseBuilder(appContext, GameDataBase::class.java, "partido_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(DatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
    private class DatabaseCallback(private val scope: CoroutineScope):RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch(Dispatchers.IO){
                    populateDatabase(it.gameDao())
                }
            }
        }
        suspend fun populateDatabase(partidoDao: GameDao){
            var game= Game(1, "Cavs", "Lakers",100 , 128, "Lakers")
            partidoDao.insert(game)
        }
    }


}