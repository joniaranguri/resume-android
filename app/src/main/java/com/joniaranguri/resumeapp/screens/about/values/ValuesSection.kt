package com.joniaranguri.resumeapp.screens.about.values

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.ValueCard
import com.joniaranguri.resumeapp.model.valuesSection
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
            valuesSection.description
        )
        valuesSection.sectionList.forEach { value ->
            ValueCard(
                value.name, value.description, getColor(value.color), value.imageUrl
            )
        }
    }
}
