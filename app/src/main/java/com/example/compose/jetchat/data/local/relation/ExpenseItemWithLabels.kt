package com.example.compose.jetchat.data.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.compose.jetchat.data.local.entity.ExpenseItemEntity
import com.example.compose.jetchat.data.local.entity.ExpenseItemLabelCrossRef
import com.example.compose.jetchat.data.local.entity.LabelEntity

data class ExpenseItemWithLabels(

    @Embedded
    val expenseItem: ExpenseItemEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = ExpenseItemLabelCrossRef::class,
            parentColumn = "expenseItemId",
            entityColumn = "labelId"
        )
    )
    val labels: List<LabelEntity>
)
