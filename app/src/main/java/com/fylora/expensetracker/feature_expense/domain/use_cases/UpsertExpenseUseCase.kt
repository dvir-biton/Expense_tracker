package com.fylora.expensetracker.feature_expense.domain.use_cases

import com.fylora.expensetracker.feature_expense.domain.model.Expense
import com.fylora.expensetracker.feature_expense.domain.repository.ExpenseRepository

class UpsertExpenseUseCase(
    private val repository: ExpenseRepository
){

    suspend operator fun invoke(expense: Expense){
        repository.upsertExpense(expense)
    }
}