package com.joniaranguri.resumeapp.screens.experience.education

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.EducationItem
import com.joniaranguri.resumeapp.model.EducationSection

@Composable
fun EducationSection(educationSection: EducationSection) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "Education",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(educationSection.description)
        educationSection.educationList.forEach { EducationItem(it) }
    }
}