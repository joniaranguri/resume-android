package com.joniaranguri.resumeapp.screens.experience.education

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.EducationItem
import com.joniaranguri.resumeapp.common.ShimmerCard
import com.joniaranguri.resumeapp.common.ShimmerText
import com.joniaranguri.resumeapp.model.EducationSection

@Composable
fun EducationSection(educationSection: EducationSection, isLoading: Boolean) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "Education",
            style = MaterialTheme.typography.titleLarge,
        )
        if (isLoading) {
            ShimmerText()
            ShimmerCard(150.dp)

        } else {
            Text(educationSection.description)
            educationSection.educationList.forEach { EducationItem(it) }
        }
    }
}