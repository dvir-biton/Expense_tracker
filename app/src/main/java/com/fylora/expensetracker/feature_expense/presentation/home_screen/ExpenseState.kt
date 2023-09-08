package com.fylora.expensetracker.feature_expense.presentation.home_screen

import com.fylora.expensetracker.feature_expense.domain.model.Expense

data class ExpenseState(
    val balance: String = "",
    val income: IncomeData = IncomeData(),
    val expenses: ExpensesData = ExpensesData(),
    val transactions: List<Expense> = emptyList()
)

data class IncomeData(
    val amount: String = "0",
    val transactionCount: String = "0"
)

data class ExpensesData(
    val amount: String = "0",
    val transactionCount: String = "0"
)
