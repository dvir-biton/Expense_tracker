package com.fylora.expensetracker.feature_expense.domain.use_cases

import com.fylora.expensetracker.feature_expense.domain.model.Expense

class CalculateTotalUseCase {

    operator fun invoke(expenses: List<Expense>): String {
        val total = expenses.sumOf {
            it.amount
        }

        return String.format("%.2f", total)
    }
}