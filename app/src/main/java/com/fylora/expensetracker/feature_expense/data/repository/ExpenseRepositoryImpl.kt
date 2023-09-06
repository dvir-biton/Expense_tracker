package com.fylora.expensetracker.feature_expense.data.repository

import com.fylora.expensetracker.feature_expense.data.data_source.ExpenseDao
import com.fylora.expensetracker.feature_expense.domain.model.Expense
import com.fylora.expensetracker.feature_expense.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    private val dao: ExpenseDao
): ExpenseRepository {
    override fun getExpenses(): Flow<List<Expense>> {
        return dao.getExpenses()
    }

    override suspend fun upsertExpense(expense: Expense) {
        dao.upsertExpense(expense)
    }

}