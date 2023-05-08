package com.joniaranguri.resumeapp.screens.projects

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.CardFace
import com.joniaranguri.resumeapp.common.ProjectFlipCard
import com.joniaranguri.resumeapp.common.ext.paddingEnd
import com.joniaranguri.resumeapp.model.projectsList
import com.joniaranguri.resumeapp.ui.theme.accentColor


@Composable
fun ProjectsScreen() {
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
                        .padding(horizontal = 16.dp)
                        .paddingEnd(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Text(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    )
                    projectsList.forEach { project ->
                        var cardFace by remember {
                            mutableStateOf(CardFace.Front)
                        }
                        ProjectFlipCard(
                            project = project,
                            color = MaterialTheme.colorScheme.onSecondary,
                            cardFace = cardFace,
                            onClick = { cardFace = cardFace.next },
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.7f),
                        )
                    }
                }

            }
        }
    }
}