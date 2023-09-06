package com.fylora.expensetracker.feature_expense.presentation.util

import androidx.compose.ui.graphics.Color
import com.fylora.expensetracker.R

sealed class TransactionTypes(
    val title: String,
    val amount: String,
    val iconId: Int,
    val type: String,
    val color: Color,
){
    class Payment(
        title: String,
        amount: String,
    ): TransactionTypes(
        title = title,
        amount = "-$$amount",
        iconId = icons[0],
        type = "Payment",
        color = Color.Red
    )
    class Received(
        title: String,
        amount: String,
    ): TransactionTypes(
        title = title,
        amount = "$$amount",
        iconId = icons[1],
        type = "Received",
        color = Color.Green
    )

    companion object{
        val icons = listOf(R.drawable.payment_icon, R.drawable.received_icon)
    }
}
