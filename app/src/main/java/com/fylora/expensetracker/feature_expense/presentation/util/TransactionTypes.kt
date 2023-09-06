package com.fylora.expensetracker.feature_expense.presentation.util

sealed class TransactionTypes(val amount: String){
    class Payment(amount: String): TransactionTypes(amount)
    class Received(amount: String): TransactionTypes(amount)
}
