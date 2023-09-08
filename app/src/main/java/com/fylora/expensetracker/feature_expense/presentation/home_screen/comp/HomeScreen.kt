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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fylora.expensetracker.core.fontFamily
import com.fylora.expensetracker.feature_expense.domain.model.Expense
import com.fylora.expensetracker.feature_expense.domain.model.toTransaction
import com.fylora.expensetracker.feature_expense.presentation.home_screen.ExpenseState
import com.fylora.expensetracker.feature_expense.presentation.home_screen.ExpensesData
import com.fylora.expensetracker.feature_expense.presentation.home_screen.IncomeData
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Background
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Primary
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Secondary
import com.fylora.expensetracker.feature_expense.presentation.util.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: ExpenseState,
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ){
                ActionButton(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(25.dp, 0.dp, 0.dp, 0.dp)),
                    color = Primary,
                    text = "Income",
                    onClick = {
                        navController.navigate(
                            route = Screens.AddScreen.screenName + "/Income"
                        )
                    }
                )
                ActionButton(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(0.dp, 25.dp, 0.dp, 0.dp)),
                    color = Secondary,
                    text = "Expense",
                    onClick = {
                        navController.navigate(
                            route = Screens.AddScreen.screenName + "/Expense"
                        )
                    }
                )
            }
        },
        contentColor = Background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF222222))
                .padding(it)
        ) {
            BalanceCard(balance = state.balance)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                DataSection(
                    title = "Income",
                    titleColor = Primary,
                    amount = state.income.amount,
                    transactionsNumber = state.income.transactionCount
                )
                DataSection(
                    title = "Expenses",
                    titleColor = Secondary,
                    amount = state.expenses.amount,
                    transactionsNumber = state.expenses.transactionCount
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                modifier = Modifier.padding(horizontal = 18.dp),
                text = "Last transactions",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
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
    HomeScreen(
        navController = rememberNavController(),
        state = ExpenseState(
            balance = "12465",
            income = IncomeData(
                amount = "1234",
                transactionCount = "4"
            ),
            expenses = ExpensesData(
                amount = "1234",
                transactionCount = "4"
            ),
            transactions = listOf(
                Expense(
                    title = "Food",
                    amount = 4124.0
                ),
                Expense(
                    title = "Food",
                    amount = -3154.0
                )
            )
        )
    )
}