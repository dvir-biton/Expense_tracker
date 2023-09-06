package com.fylora.expensetracker.feature_expense.presentation.home_screen

import com.fylora.expensetracker.feature_expense.domain.model.Expense

data class ExpenseState(
    val balance: String = "",
    val incomeAmount: String = "",
    val incomeTransaction: String = "",
    val expenseAmount: String = "",
    val expenseTransaction: String = "",
    val transactions: List<Expense> = emptyList()
)
