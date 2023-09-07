package com.fylora.expensetracker.feature_expense.domain.use_cases

data class UseCases(
    val calculateTotalUseCase: CalculateTotalUseCase,
    val upsertExpenseUseCase: UpsertExpenseUseCase,
    val getExpensesUseCase: GetExpensesUseCase
)
