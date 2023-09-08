package com.fylora.expensetracker.feature_expense.domain.use_cases

import com.fylora.expensetracker.feature_expense.domain.model.Expense
import com.fylora.expensetracker.feature_expense.domain.model.toTransaction
import com.fylora.expensetracker.feature_expense.presentation.util.TransactionTypes

class CalculateExpensesUseCase {

    operator fun invoke(expenses: List<Expense>): List<String> {
        var expensesAmount = 0.0
        var incomeAmount = 0.0
        var incomeTransactions = 0
        var expenseTransactions = 0

        expenses.forEach { expense ->
            when(expense.toTransaction()){
                is TransactionTypes.Payment -> {
                    expensesAmount += expense.amount
                    expenseTransactions++
                }
                is TransactionTypes.Received -> {
                    incomeAmount += expense.amount
                    incomeTransactions++
                }
            }
        }

        return listOf(
            incomeAmount.toString(),
            incomeTransactions.toString(),
            (expensesAmount * -1).toString(),
            expenseTransactions.toString()
        )
    }
}