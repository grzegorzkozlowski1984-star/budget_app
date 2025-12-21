package com.example.compose.jetchat.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "expense_item_labels",
    primaryKeys = ["expenseItemId", "labelId"],
    foreignKeys = [
        ForeignKey(
            entity = ExpenseItemEntity::class,
            parentColumns = ["id"],
            childColumns = ["expenseItemId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = LabelEntity::class,
            parentColumns = ["id"],
            childColumns = ["labelId"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index("expenseItemId"),
        Index("labelId")
    ]
)
data class ExpenseItemLabelCrossRef(
    val expenseItemId: Long,
    val labelId: Long
)
