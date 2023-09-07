package com.fylora.expensetracker.feature_expense.presentation.home_screen.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.expensetracker.core.fontFamily
import com.fylora.expensetracker.feature_expense.domain.model.toTransaction
import com.fylora.expensetracker.feature_expense.presentation.home_screen.ExpenseState
import com.fylora.expensetracker.feature_expense.presentation.home_screen.ExpensesData
import com.fylora.expensetracker.feature_expense.presentation.home_screen.IncomeData
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Primary
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: ExpenseState
) {
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .background(Color(0xFF343434))
            ){
                ActionButton(
                    color = Primary,
                    text = "New income",
                    onClick = { /* TODO nav host */ }
                )
                ActionButton(
                    color = Secondary,
                    text = "New expense",
                    onClick = { /* TODO nav host */ }
                )
            }
        },
        contentColor = Color(0xFF222222)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF222222))
                .padding(it)
        ) {
            BalanceCard(balance = "12414")

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                DataSection(
                    title = "Income",
                    titleColor = Primary,
                    amount = "7762.42",
                    transactionsNumber = "3"
                )
                DataSection(
                    title = "Expenses",
                    titleColor = Secondary,
                    amount = "6262.97",
                    transactionsNumber = "12"
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Last transactions",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                fontFamily = fontFamily
            )

            LazyColumn(
                content = {
                    items(state.transactions){ expense ->
                        Transaction(
                            transactionType = expense.toTransaction()
                        )
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
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
    ))
}