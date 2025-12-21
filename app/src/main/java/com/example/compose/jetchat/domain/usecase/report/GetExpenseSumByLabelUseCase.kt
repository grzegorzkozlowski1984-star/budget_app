package com.example.compose.jetchat.domain.usecase.report

import com.example.compose.jetchat.data.local.dao.ExpenseItemDao
import com.example.compose.jetchat.data.local.query.ExpenseSumByLabel
import java.time.LocalDateTime

class GetExpenseSumByLabelUseCase(
    private val expenseItemDao: ExpenseItemDao
) {

    suspend operator fun invoke(
        from: LocalDateTime,
        to: LocalDateTime
    ): List<ExpenseSumByLabel> {
        return expenseItemDao.getExpenseSumByLabel(from, to)
    }
}
