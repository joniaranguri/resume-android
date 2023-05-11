package com.joniaranguri.resumeapp.screens.experience

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joniaranguri.resumeapp.common.ext.paddingEnd
import com.joniaranguri.resumeapp.screens.experience.education.EducationSection
import com.joniaranguri.resumeapp.screens.experience.languages.LanguagesSection
import com.joniaranguri.resumeapp.screens.experience.work.WorkSection
import com.joniaranguri.resumeapp.ui.theme.accentColor

@Composable
fun ExperienceScreen(
    openScreen: (String) -> Unit, viewModel: ExperienceViewModel = hiltViewModel()
) {
    val workSection by viewModel.workSection
    val educationSection by viewModel.educationSection
    val languagesSection by viewModel.languagesSection
    val isLoading by viewModel.isLoading

    LaunchedEffect(Unit) { viewModel.initialize() }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "My profesional", style = MaterialTheme.typography.titleLarge,
                    )
                    Text(
                        text = "experience",
                        style = MaterialTheme.typography.titleLarge,
                        color = accentColor
                    )
                }

            }
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    WorkSection(openScreen = openScreen, workSection, isLoading)
                    EducationSection(educationSection, isLoading)
                }
            }
            item {
                LanguagesSection(languagesSection)
            }
        }
    }
}