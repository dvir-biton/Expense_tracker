package com.fylora.expensetracker.feature_expense.presentation.util

sealed class Screens(val screenName: String){
    object HomeScreen : Screens("home_screen")
    object AddScreen : Screens("add_screen")
}
