package com.fylora.expensetracker.feature_expense.presentation.util

import androidx.compose.ui.graphics.Color
import com.fylora.expensetracker.R
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Primary
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Secondary

sealed class TransactionTypes(
    val title: String,
    val amount: String,
    val iconId: Int,
    val type: String,
    val color: Color,
    val screenTitle: String
){
    class Payment(
        title: String,
        amount: String,
    ): TransactionTypes(
        title = title,
        amount = "-$$amount",
        iconId = icons[0],
        type = "Payment",
        color = Secondary,
        screenTitle = "Expense"
    )
    class Received(
        title: String,
        amount: String,
    ): TransactionTypes(
        title = title,
        amount = "$$amount",
        iconId = icons[1],
        type = "Received",
        color = Primary,
        screenTitle = "Income"
    )

    companion object{
        val icons = listOf(R.drawable.payment_icon, R.drawable.received_icon)
    }
}
