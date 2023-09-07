package com.fylora.expensetracker.feature_expense.presentation.home_screen.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.expensetracker.core.fontFamily
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Tertiary
import com.fylora.expensetracker.feature_expense.presentation.util.TransactionTypes

@Composable
fun Transaction(
    transactionType: TransactionTypes
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Tertiary),
            contentAlignment = Alignment.Center
        ){
            Icon(
                modifier = Modifier
                    .padding(16.dp),
                painter = painterResource(id = transactionType.iconId),
                contentDescription = null
            )
        }

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = transactionType.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                fontFamily = fontFamily
            )
            Text(
                text = transactionType.type,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                fontFamily = fontFamily
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = transactionType.amount,
            color = transactionType.color,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            fontFamily = fontFamily
        )
    }
}

@Preview
@Composable
fun TransactionPreview() {
    Transaction(transactionType = TransactionTypes.Payment("Food", "930"))
}