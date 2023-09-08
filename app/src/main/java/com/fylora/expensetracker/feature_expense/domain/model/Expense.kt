package com.fylora.expensetracker.feature_expense.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fylora.expensetracker.feature_expense.presentation.util.TransactionTypes

@Entity
data class Expense(
    val title: String,
    val amount: Double,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

class InvalidExpenseException(message: String) : Exception(message)

fun Expense.toTransaction(): TransactionTypes{
    return if(this.amount > 0)
        TransactionTypes.Received(
            title = this.title,
            amount = if(this.amount.isWholeNumber())
                this.amount.toInt().toString()
            else this.amount.toString()
        )
    else TransactionTypes.Payment(
        title = this.title,
        amount = if(this.amount.isWholeNumber())
            (this.amount.toInt() * -1).toString()
        else (this.amount * -1).toString(),
    )
}

fun Double.isWholeNumber(): Boolean{
    return this == this.toInt().toDouble()
}