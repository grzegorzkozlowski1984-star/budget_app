package com.example.compose.jetchat.domain.usecase.report

import com.example.compose.jetchat.data.local.dao.ExpenseItemDao
import java.time.LocalDateTime

class GetExpenseSumWithoutLabelUseCase(
    private val expenseItemDao: ExpenseItemDao
) {

    suspend operator fun invoke(
        from: LocalDateTime,
        to: LocalDateTime
    ): Double {
        return expenseItemDao.getExpenseSumWithoutLabel(from, to) ?: 0.0
    }
}
