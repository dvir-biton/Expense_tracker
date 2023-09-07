package com.fylora.expensetracker.feature_expense.presentation.home_screen.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.expensetracker.core.fontFamily
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Primary

@Composable
fun BalanceCard(
    balance: String
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .background(Primary)
    ) {
        Text(
            text = "Main wallet",
            modifier = Modifier
                .padding(30.dp),
            fontSize = 28.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = fontFamily
        )
        Text(
            text = "Your balance",
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(vertical = 10.dp),
            fontSize = 16.sp,
            color = Color(0xFFEAEAEA),
            fontWeight = FontWeight.ExtraBold,
            fontFamily = fontFamily
        )
        Text(
            text = "$$balance",
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(bottom = 20.dp),
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = fontFamily
        )
    }
}

@Preview
@Composable
fun BalanceCardPrev() {
    BalanceCard(balance = "1204.12")
}