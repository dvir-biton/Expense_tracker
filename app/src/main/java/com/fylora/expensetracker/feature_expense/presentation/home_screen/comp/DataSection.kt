package com.fylora.expensetracker.feature_expense.presentation.home_screen.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.expensetracker.core.fontFamily
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Primary
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Secondary
import org.w3c.dom.CDATASection

@Composable
fun DataSection(
    title: String,
    titleColor: Color,
    amount: String,
    transactionsNumber: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier.padding(vertical = 12.dp),
            text = title,
            color = titleColor,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp,
            fontFamily = fontFamily
        )

        DataSectionValue(
            amount = "$$amount",
            type = "Amount"
        )
        DataSectionValue(
            amount = transactionsNumber,
            type = "Transactions"
        )
    }
}

@Composable
fun DataSectionValue(
    amount: String,
    type: String
) {
    Text(
        text = amount,
        color = Color.White,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        fontFamily = fontFamily
    )
    Text(
        text = type,
        fontSize = 16.sp,
        color = Color(0xFFEAEAEA),
        fontWeight = FontWeight.SemiBold,
        fontFamily = fontFamily
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF222222)
@Composable
fun DataSectionRow() {
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
}