package com.example.compose.jetchat.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.compose.jetchat.data.local.entity.ExpenseItemEntity
import com.example.compose.jetchat.data.local.entity.TransactionEntity

data class TransactionWithItems(
    @Embedded
    val transaction: TransactionEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "transactionId"
    )
    val items: List<ExpenseItemEntity>
)
