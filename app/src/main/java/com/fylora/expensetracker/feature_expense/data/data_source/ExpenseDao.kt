package com.fylora.expensetracker.feature_expense.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.fylora.expensetracker.feature_expense.domain.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expense ORDER BY id DESC")
    fun getExpenses(): Flow<List<Expense>>

    @Upsert
    suspend fun upsertExpense(expense: Expense)
}