package com.fylora.expensetracker.feature_expense.presentation.add_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.fylora.expensetracker.core.fontFamily

@Composable
fun InvisibleBorderTextField(
    modifier: Modifier = Modifier,
    text: String,
    hint: String,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .onFocusChanged {
                    onFocusChange(it)
                },
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = fontFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            )
        )
        if(isHintVisible){
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = hint,
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                ),
                color = Color.Gray,
            )
        }
    }
}

@Preview
@Composable
fun TestFieldPreview() {
    InvisibleBorderTextField(
        modifier = Modifier
            .fillMaxWidth(),
        text = "Text Text",
        hint = "",
        onValueChange = {},
        onFocusChange = {},
        isHintVisible = true,
        singleLine = true,
    )
}