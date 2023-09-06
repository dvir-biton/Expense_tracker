package com.fylora.expensetracker.core

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.fylora.expensetracker.R

object Fonts {
    val fontFamily = FontFamily(
        Font(
            R.font.nunito_regular,
            FontWeight.Normal
        ),
        Font(
            R.font.nunito_light,
            FontWeight.Light
        ),
        Font(
            R.font.nunito_extrabold,
            FontWeight.ExtraBold
        ),
        Font(
            R.font.nunito_bold,
            FontWeight.Bold
        ),
        Font(
            R.font.nunito_black,
            FontWeight.Black
        ),
        Font(
            R.font.nunito_medium,
            FontWeight.Medium
        ),
        Font(
            R.font.nunito_extralight,
            FontWeight.ExtraLight
        ),
        Font(
            R.font.nunito_italic,
            style = FontStyle.Italic
        )
    )
}

val fontFamily = Fonts.fontFamily