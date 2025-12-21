package com.example.compose.jetchat.domain.usecase.report

import com.example.compose.jetchat.data.local.dao.ExpenseItemDao
import java.time.LocalDateTime

class GetExpenseSumTotalUseCase(
    private val expenseItemDao: ExpenseItemDao
) {

    suspend operator fun invoke(
        from: LocalDateTime,
        to: LocalDateTime
    ): Double {
        return expenseItemDao.getTotalExpenseSum(from, to) ?: 0.0
    }
}
