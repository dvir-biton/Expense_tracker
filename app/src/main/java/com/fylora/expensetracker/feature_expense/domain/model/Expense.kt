package com.fylora.expensetracker.feature_expense.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fylora.expensetracker.feature_expense.presentation.util.TransactionTypes

@Entity
data class Expense(
    val title: String,
    val type: String,
    val amount: Double,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

fun Expense.toTransaction(): TransactionTypes{
    return if(this.amount > 0)
        TransactionTypes.Received(
            title = this.title,
            amount = this.amount.toString()
        )
    else TransactionTypes.Payment(
        title = this.title,
        amount = this.amount.toString()
    )
}