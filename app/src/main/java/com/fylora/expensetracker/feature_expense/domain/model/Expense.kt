package com.fylora.expensetracker.feature_expense.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    val title: String,
    val type: String,
    val amount: Double,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
