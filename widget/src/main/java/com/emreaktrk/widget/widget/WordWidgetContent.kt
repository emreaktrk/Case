package com.emreaktrk.widget.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

@Composable
fun WordWidgetContent(
    content: String,
    fontWeight: FontWeight
) {
    Text(
        text = content,
        style = TextStyle(
            fontWeight = fontWeight,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            color = ColorProvider(
                color = Color.White
            )
        ),
    )
}