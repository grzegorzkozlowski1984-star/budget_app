package com.example.compose.jetchat.data.local.entity

import androidx.room.*

@Entity(
    tableName = "categories",
    indices = [
        Index("parentId")
    ],
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["parentId"],
            onDelete = ForeignKey.RESTRICT
        )
    ]
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val parentId: Long?,
    val order: Int,
    val isSystem: Boolean = false
)
