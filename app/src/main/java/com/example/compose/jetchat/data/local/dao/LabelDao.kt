package com.example.compose.jetchat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.compose.jetchat.data.local.entity.LabelEntity

@Dao
interface LabelDao {

    @Insert
    suspend fun insert(label: LabelEntity): Long

    @Query("SELECT * FROM labels ORDER BY name")
    suspend fun getAll(): List<LabelEntity>
}
