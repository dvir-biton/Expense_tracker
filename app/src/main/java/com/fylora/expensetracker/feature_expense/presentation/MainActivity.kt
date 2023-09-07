package com.fylora.expensetracker.feature_expense.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fylora.expensetracker.feature_expense.presentation.home_screen.ExpenseState
import com.fylora.expensetracker.feature_expense.presentation.home_screen.ExpensesData
import com.fylora.expensetracker.feature_expense.presentation.home_screen.IncomeData
import com.fylora.expensetracker.feature_expense.presentation.home_screen.comp.HomeScreen
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.ExpenseTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                HomeScreen(state = ExpenseState(
                    balance = "12465",
                    income = IncomeData(
                        amount = "1234",
                        transactionCount = "4"
                    ),
                    expenses = ExpensesData(
                        amount = "1234",
                        transactionCount = "4"
                    )
                )
                )
            }
        }
    }
}
