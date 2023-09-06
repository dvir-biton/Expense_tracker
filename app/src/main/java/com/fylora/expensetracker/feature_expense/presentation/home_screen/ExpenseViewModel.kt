package com.fylora.expensetracker.feature_expense.presentation.home_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fylora.expensetracker.feature_expense.domain.model.Expense
import com.fylora.expensetracker.feature_expense.domain.use_cases.CalculateTotalUseCase
import com.fylora.expensetracker.feature_expense.domain.use_cases.GetExpensesUseCase
import com.fylora.expensetracker.feature_expense.domain.use_cases.UpsertExpenseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val getExpensesUseCase: GetExpensesUseCase,
    private val calculateTotalUseCase: CalculateTotalUseCase
): ViewModel(){
    private val _state = mutableStateOf(ExpenseState())
    val state = _state

    init {
        updateExpenses()
    }

    fun updateExpenses(){
        viewModelScope.launch {
            getExpensesUseCase().collectLatest { expenses ->
                _state.value = state.value.copy(
                    transactions = expenses,
                    balance = calculateTotalUseCase(expenses)
                )
            }
        }
    }
}