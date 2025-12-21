package com.example.compose.jetchat.domain.usecase.report

import com.example.compose.jetchat.data.local.dao.ExpenseItemDao
import com.example.compose.jetchat.data.local.query.ExpenseSumByLabelAndCategory
import java.time.LocalDateTime

class GetExpenseSumByLabelAndCategoryUseCase(
    private val expenseItemDao: ExpenseItemDao
) {

    suspend operator fun invoke(
        from: LocalDateTime,
        to: LocalDateTime
    ): List<ExpenseSumByLabelAndCategory> {
        return expenseItemDao.getExpenseSumByLabelAndCategory(from, to)
    }
}
