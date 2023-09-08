package com.fylora.expensetracker.feature_expense.domain.use_cases

import com.fylora.expensetracker.feature_expense.domain.model.Expense
import com.fylora.expensetracker.feature_expense.domain.model.InvalidExpenseException
import com.fylora.expensetracker.feature_expense.domain.repository.ExpenseRepository

class UpsertExpenseUseCase(
    private val repository: ExpenseRepository
){

    suspend operator fun invoke(expense: Expense){
        if(expense.amount == 0.0){
            throw InvalidExpenseException("The expense amount cannot be empty")
        }
        if(expense.title.isBlank()){
            throw InvalidExpenseException("The title cannot be empty")
        }

        repository.upsertExpense(expense)
    }
}