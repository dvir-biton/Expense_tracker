package com.fylora.expensetracker.feature_expense.presentation.add_screen

import androidx.compose.ui.focus.FocusState

sealed class AddEvent{
    data class AddNumber(val number: String): AddEvent()
    object Delete: AddEvent()
    object EnterDecimal: AddEvent()
    object Enter: AddEvent()

    data class TextFieldAction(val textFieldEvent: TextFieldEvent): AddEvent()
}

sealed class TextFieldEvent {
    data class ChangeTitleFocus(val focusState: FocusState): TextFieldEvent()
    data class EnteredContent(val content: String): TextFieldEvent()
}