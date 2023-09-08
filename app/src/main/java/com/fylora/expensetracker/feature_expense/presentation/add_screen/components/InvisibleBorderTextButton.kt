package com.fylora.expensetracker.feature_expense.presentation.add_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.expensetracker.R
import com.fylora.expensetracker.core.fontFamily

@Composable
fun InvisibleBorderTextButton(
    icon: Painter? = null,
    symbol: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.clickable { onClick() }
    ){
        if(icon != null){
            Icon(
                modifier = Modifier.padding(
                    vertical = 30.dp,
                    horizontal = 30.dp
                ),
                painter = icon,
                tint = Color.White,
                contentDescription = null
            )
        } else{
            Text(
                text = symbol,
                modifier = Modifier.padding(
                    vertical = 30.dp,
                    horizontal = 40.dp
                ),
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 32.sp,
            )
        }
    }
}

@Preview
@Composable
fun PreviewButton() {
    Row {
        InvisibleBorderTextButton(symbol = "7") {}
        InvisibleBorderTextButton(
            symbol = "",
            icon = painterResource(id = R.drawable.backspace)
        ) {}
    }
}