package com.example.compose.jetchat.data.local.query

data class ExpenseSumByLabelAndCategory(
    val labelId: Long?,
    val labelName: String?,
    val categoryId: Long,
    val categoryName: String,
    val sum: Double
)
