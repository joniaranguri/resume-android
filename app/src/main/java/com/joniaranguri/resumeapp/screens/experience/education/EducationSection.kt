package com.joniaranguri.resumeapp.screens.experience.education

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.EducationItem
import com.joniaranguri.resumeapp.model.educationList

@Composable
fun EducationSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "Education",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
        )
        educationList.forEach { EducationItem(it) }
    }
}