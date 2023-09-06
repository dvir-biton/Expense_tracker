package com.fylora.expensetracker.feature_expense.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fylora.expensetracker.feature_expense.domain.model.Expense

@Database(
    entities = [Expense::class],
    version = 1,
    exportSchema = false
)
abstract class ExpenseDatabase(): RoomDatabase() {

    abstract val dao: ExpenseDao
}