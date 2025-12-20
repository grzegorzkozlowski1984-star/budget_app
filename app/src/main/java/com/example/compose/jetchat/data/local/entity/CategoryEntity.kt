package com.example.compose.jetchat.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    val name: String,

    /**
     * null → kategoria główna
     * != null → podkategoria
     */
    val parentId: Long? = null,

    /**
     * 1 = główna
     * 2 = podkategoria
     * 3 = pod-podkategoria
     */
    val level: Int,

    /**
     * true = systemowa (np. "Inne"), nieusuwalna
     */
    val isSystem: Boolean = false
)

