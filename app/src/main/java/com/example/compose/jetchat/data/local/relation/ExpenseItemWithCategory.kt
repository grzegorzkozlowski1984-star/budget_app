package com.example.compose.jetchat.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.compose.jetchat.data.local.entity.CategoryEntity
import com.example.compose.jetchat.data.local.entity.ExpenseItemEntity

data class ExpenseItemWithCategory(
    @Embedded
    val item: ExpenseItemEntity,

    @Relation(
        parentColumn = "categoryId",
        entityColumn = "id"
    )
    val category: CategoryEntity
)
