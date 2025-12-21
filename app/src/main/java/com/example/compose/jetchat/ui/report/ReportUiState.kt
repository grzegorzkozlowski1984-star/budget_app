package com.example.compose.jetchat.ui.report

import com.example.compose.jetchat.data.local.query.*

data class ReportUiState(
    val reportType: ReportType = ReportType.TOTAL,
    val totalAmount: Double? = null,
    val byLabel: List<ExpenseSumByLabel> = emptyList(),
    val byLabelAndCategory: List<ExpenseSumByLabelAndCategory> = emptyList(),
    val withoutLabelAmount: Double? = null,
    val isLoading: Boolean = false
)
