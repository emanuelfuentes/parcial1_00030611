package com.emma.myapplication.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Game")
data class Game(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val idGame: Int?=0,
    @ColumnInfo(name = "hometeam") val home: String,

    @ColumnInfo(name = "visitorteam") val visitor: String,

    @ColumnInfo(name="homepoints") val hpoints:Int,

    @ColumnInfo(name="visitpoints") val vpoints:Int,

    @ColumnInfo(name="winner")val winner:String

) {
}