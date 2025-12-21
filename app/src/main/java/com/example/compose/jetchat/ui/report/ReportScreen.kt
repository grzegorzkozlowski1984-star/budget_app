package com.example.compose.jetchat.ui.report

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReportScreen(
    viewModel: ReportViewModel
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.refresh()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        ReportTypeSelector(
            selected = state.reportType,
            onSelected = viewModel::setReportType
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            return
        }

        when (state.reportType) {
            ReportType.TOTAL -> {
                TotalReport(state.totalAmount)
            }

            ReportType.BY_LABEL -> {
                ByLabelReport(state.byLabel)
            }

            ReportType.BY_LABEL_AND_CATEGORY -> {
                ByLabelAndCategoryReport(state.byLabelAndCategory)
            }

            ReportType.WITHOUT_LABEL -> {
                WithoutLabelReport(state.withoutLabelAmount)
            }
        }
    }
}
@Composable
private fun ReportTypeSelector(
    selected: ReportType,
    onSelected: (ReportType) -> Unit
) {
    Column {
        Text("Typ raportu", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))

        ReportType.values().forEach { type ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selected == type,
                    onClick = { onSelected(type) }
                )
                Text(text = type.name)
            }
        }
    }
}
