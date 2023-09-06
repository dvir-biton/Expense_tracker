package com.fylora.expensetracker.feature_expense.presentation.home_screen

import androidx.compose.runtime.mutableStateOf
import com.fylora.expensetracker.feature_expense.domain.use_cases.GetExpensesUseCase
import com.fylora.expensetracker.feature_expense.domain.use_cases.UpsertExpenseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    getExpensesUseCase: GetExpensesUseCase,
    upsertExpenseUseCase: UpsertExpenseUseCase
){
    private val _state = mutableStateOf(ExpenseState())
    val state = _state

    init {
        getExpensesUseCase()
    }


}