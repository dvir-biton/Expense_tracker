package com.fylora.expensetracker.feature_expense.presentation.home_screen.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Secondary

@Composable
fun ActionButton(
    color: Color,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(color)
            .clickable { onClick() }
    ){
        Text(
            text = text,
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(vertical = 16.dp),
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = fontFamily,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun ActionButtonPreview() {
    ActionButton(
        color = Secondary,
        text = "New expense",
        onClick = {}
    )
}