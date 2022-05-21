package com.emreaktrk.widget.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.LocalContext
import androidx.glance.appwidget.*
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import com.emreaktrk.data.db.WordDatabase
import com.emreaktrk.data.word.WordLocalDataSource

class WordWidget : GlanceAppWidget() {

    @Composable
    override fun Content() {
        val context = LocalContext.current
        val db = WordDatabase.getInstance(context)
        val ds = WordLocalDataSource(db.wordDao())
        val random = ds.random()

        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(
                    day = Color(0xFF6650a4),
                    night = Color(0xFF625b71),
                ).appWidgetBackground()
                .cornerRadius(16.dp)
                .padding(8.dp),
        ) {
            WordWidgetContent(
                content = random.word,
                fontWeight = FontWeight.Bold
            )
            WordWidgetContent(
                content = random.defination,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

class WordWidgetReceiver : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget = WordWidget()
}