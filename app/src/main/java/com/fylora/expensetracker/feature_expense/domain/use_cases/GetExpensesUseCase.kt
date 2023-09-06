package com.fylora.expensetracker.feature_expense.domain.use_cases

import com.fylora.expensetracker.feature_expense.domain.model.Expense
import com.fylora.expensetracker.feature_expense.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow

class GetExpensesUseCase(
    private val repository: ExpenseRepository
) {

    operator fun invoke(): Flow<List<Expense>> {
        return repository.getExpenses()
    }
}