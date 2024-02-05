package com.example.hstoneapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun CustomVerticalCard(
    modifierCard: Modifier,
    painterImage: Painter,
    contentDescriptorImage: String
) {
    Card(
        modifier = modifierCard,
    ) {
        Image(
            painter = painterImage,
            contentDescription = contentDescriptorImage
        )
    }
}