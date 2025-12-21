package com.example.compose.jetchat.ui.report

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.jetchat.domain.usecase.report.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class ReportViewModel(
    private val getExpenseSumTotal: GetExpenseSumTotalUseCase,
    private val getExpenseSumByLabel: GetExpenseSumByLabelUseCase,
    private val getExpenseSumByLabelAndCategory: GetExpenseSumByLabelAndCategoryUseCase,
    private val getExpenseSumWithoutLabel: GetExpenseSumWithoutLabelUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ReportUiState())
    val uiState: StateFlow<ReportUiState> = _uiState

    private var from: LocalDateTime = LocalDateTime.now().withDayOfMonth(1)
    private var to: LocalDateTime = LocalDateTime.now()

    fun setDateRange(from: LocalDateTime, to: LocalDateTime) {
        this.from = from
        this.to = to
        refresh()
    }

    fun setReportType(type: ReportType) {
        _uiState.value = _uiState.value.copy(reportType = type)
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            when (_uiState.value.reportType) {
                ReportType.TOTAL -> {
                    val total = getExpenseSumTotal(from, to)
                    _uiState.value = _uiState.value.copy(
                        totalAmount = total,
                        isLoading = false
                    )
                }

                ReportType.BY_LABEL -> {
                    val result = getExpenseSumByLabel(from, to)
                    _uiState.value = _uiState.value.copy(
                        byLabel = result,
                        isLoading = false
                    )
                }

                ReportType.BY_LABEL_AND_CATEGORY -> {
                    val result = getExpenseSumByLabelAndCategory(from, to)
                    _uiState.value = _uiState.value.copy(
                        byLabelAndCategory = result,
                        isLoading = false
                    )
                }

                ReportType.WITHOUT_LABEL -> {
                    val total = getExpenseSumWithoutLabel(from, to)
                    _uiState.value = _uiState.value.copy(
                        withoutLabelAmount = total,
                        isLoading = false
                    )
                }
            }
        }
    }
}
