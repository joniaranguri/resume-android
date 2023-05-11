package com.joniaranguri.resumeapp.screens.about

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
import com.joniaranguri.resumeapp.screens.about.hobbies.HobbiesSection
import com.joniaranguri.resumeapp.screens.about.profile.ProfileSection
import com.joniaranguri.resumeapp.screens.about.values.ValuesSection
import com.joniaranguri.resumeapp.ui.theme.accentColor

@Composable
fun AboutScreen(
    viewModel: AboutViewModel = hiltViewModel()
) {
    val profileSection by viewModel.profileSection
    val valuesSection by viewModel.valuesSection
    val hobbiesSection by viewModel.hobbiesSection
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
                        text = "This is me,", style = MaterialTheme.typography.titleLarge,
                    )
                    Text(
                        text = "Jonathan Aranguri",
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
                    ProfileSection(profileSection, isLoading)
                    ValuesSection(valuesSection, isLoading)
                }
            }
            item {
                HobbiesSection(hobbiesSection.hobbiesList, isLoading)
            }
        }
    }
}