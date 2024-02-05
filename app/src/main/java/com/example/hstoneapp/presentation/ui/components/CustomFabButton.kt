package com.example.hstoneapp.presentation.ui.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun CustomFabButton(
    contextRef: Activity,
    modifierFab: Modifier,
    backgroundFabColor: Color,
    modifierImage: Modifier,
    painterImage: Painter,
    contentDescriptionImage: String
) {
    FloatingActionButton(
        onClick = { contextRef.finish() },
        modifier = modifierFab,
        contentColor = backgroundFabColor,
    ) {
        Image(
            painter = painterImage,
            contentDescription = contentDescriptionImage,
            modifier = modifierImage
        )
    }
}