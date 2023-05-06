package com.joniaranguri.resumeapp.screens.about.values

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.ValueCard
import com.joniaranguri.resumeapp.model.valuesList
import com.joniaranguri.resumeapp.ui.theme.getColor

@Composable
fun ValuesSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "My values",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "During my career, I have learnt some valuable lessons from life and work. I want to share with you some of it which I take as my personal values. Guess what: Two of them are values from Blinkist!",
        )
        valuesList.forEach { value ->
            ValueCard(
                value.name, value.description, getColor(value.color), value.imageUrl
            )
        }
    }
}
