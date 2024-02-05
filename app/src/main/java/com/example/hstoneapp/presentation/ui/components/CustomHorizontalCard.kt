package com.example.hstoneapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import kotlin.random.Random

@Composable
fun CustomHorizontalCard(
    text: String,
    font: FontFamily,
    modifierText: Modifier,
    colorCard: Color,
    colorText: Color,
    fontSizeText: TextUnit,
    textAlign: TextAlign,
    shapeSize: RoundedCornerShape,
    modifierColumn: Modifier,
    modifierCard: Modifier
) {
    Card(
        modifier = modifierCard,
        shape = shapeSize,
        colors = CardDefaults.cardColors(containerColor = colorCard)
    ) {
        Column(
            modifierColumn
        ) {

            Text(
                text = text,
                textAlign = textAlign,
                color = colorText,
                fontSize = fontSizeText,
                modifier = modifierText,
                fontFamily = font
            )

        }
    }
}

fun randomColor() = Color(
    Random.nextInt(255),
    Random.nextInt(255),
    Random.nextInt(255)
)
