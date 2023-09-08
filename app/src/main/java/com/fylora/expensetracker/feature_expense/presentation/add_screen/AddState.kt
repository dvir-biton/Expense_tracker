package com.fylora.expensetracker.feature_expense.presentation.add_screen

import com.fylora.expensetracker.feature_expense.presentation.util.TransactionTypes

data class AddState(
    val amount: String = "",
    val textField: TextFieldState = TextFieldState(),
    val type: TransactionTypes? = null
)

data class TextFieldState(
    val textValue: String = "",
    val isHintVisible: Boolean = true
)
