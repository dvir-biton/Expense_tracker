package com.fylora.expensetracker.feature_expense.presentation.home_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fylora.expensetracker.feature_expense.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel(){
    private val _state = mutableStateOf(ExpenseState())
    val state = _state

    init {
        updateExpenses()
    }

    private fun updateExpenses() {
        viewModelScope.launch {
            useCases.getExpensesUseCase().collectLatest { expenses ->
                val incomeAndExpenseAmounts = useCases.calculateExpensesUseCase(expenses)
                _state.value = state.value.copy(
                    transactions = expenses,
                    balance = useCases.calculateTotalUseCase(expenses),
                    income = IncomeData(
                        amount = incomeAndExpenseAmounts[0],
                        transactionCount = incomeAndExpenseAmounts[1]
                    ),
                    expenses = ExpensesData(
                        amount = incomeAndExpenseAmounts[2],
                        transactionCount = incomeAndExpenseAmounts[3]
                    )
                )
            }
        }
    }
}