package com.fylora.expensetracker.feature_expense.presentation.util

sealed class TransactionTypes{
    class Payment(amount: String): TransactionTypes()
    class Received(amount: String): TransactionTypes()
}
