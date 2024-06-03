package com.joniaranguri.resumeapp.screens.projects

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import com.joniaranguri.resumeapp.ResumeApplication
import com.joniaranguri.resumeapp.common.CardFace
import com.joniaranguri.resumeapp.common.ProjectFlipCard
import com.joniaranguri.resumeapp.common.ShimmerCard
import com.joniaranguri.resumeapp.common.ShimmerText
import com.joniaranguri.resumeapp.model.ProjectsSection
import com.joniaranguri.resumeapp.screens.projects.ProjectsViewModel.Companion.ANALYTICS_EVENT_PROJECT
import com.joniaranguri.resumeapp.screens.work_detail.WorkDetailViewModel
import com.joniaranguri.resumeapp.ui.theme.accentColor

@Composable
fun ProjectsScreen(viewModel: ProjectsViewModel = hiltViewModel()) {
    val projectsSection by viewModel.projectsSection
    val isLoading by viewModel.isLoading

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Some interesting", style = MaterialTheme.typography.titleLarge,
                    )
                    Text(
                        text = "projects",
                        style = MaterialTheme.typography.titleLarge,
                        color = accentColor
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    if (isLoading) {
                        ShimmerText()
                        repeat(5) {
                            ShimmerCard(150.dp)
                        }
                    } else ProjectsContent(projectsSection)

                }
            }
        }
    }
}

@Composable
fun ProjectsContent(projectsSection: ProjectsSection) {
    Text(projectsSection.description)
    projectsSection.projectsList.forEach {
        var cardFace by remember {
            mutableStateOf(CardFace.Front)
        }
        ProjectFlipCard(
            project = it,
            color = MaterialTheme.colorScheme.onSecondary,
            cardFace = cardFace,
            onClick = { _ ->
                FirebaseAnalytics.getInstance(ResumeApplication.instance)
                    .logEvent(ANALYTICS_EVENT_PROJECT, Bundle().apply {
                        putString("name", it.name)
                    })
                cardFace = cardFace.next
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.7f),
        )
    }
}
