package com.fylora.expensetracker.feature_expense.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fylora.expensetracker.feature_expense.presentation.add_screen.AddViewModel
import com.fylora.expensetracker.feature_expense.presentation.add_screen.components.AddScreen
import com.fylora.expensetracker.feature_expense.presentation.home_screen.ExpenseViewModel
import com.fylora.expensetracker.feature_expense.presentation.home_screen.comp.HomeScreen
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.ExpenseTrackerTheme
import com.fylora.expensetracker.feature_expense.presentation.util.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                val navController = rememberNavController()
                val expenseViewModel = viewModel<ExpenseViewModel>()
                val addViewModel = viewModel<AddViewModel>()

                NavHost(
                    navController = navController,
                    startDestination = Screens.HomeScreen.screenName
                ) {
                    composable(Screens.HomeScreen.screenName){
                        HomeScreen(
                            state = expenseViewModel.state.value,
                            navController = navController
                        )
                    }
                    composable(
                        route = Screens.AddScreen.screenName + "/{type}",
                        arguments = listOf(navArgument("type") { type = NavType.StringType})
                    ) { backStackEntry ->
                        val type = backStackEntry.arguments?.getString("type")

                        addViewModel.setTransactionTypeFromString(type ?: "none")

                        AddScreen(
                            viewModel = addViewModel,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
