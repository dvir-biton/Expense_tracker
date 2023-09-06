package com.fylora.expensetracker.feature_expense.domain.repository

import com.fylora.expensetracker.feature_expense.domain.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {

    fun getExpenses(): Flow<List<Expense>>

    suspend fun upsertExpense(expense: Expense)
}