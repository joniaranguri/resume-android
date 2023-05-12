package com.joniaranguri.resumeapp.screens.work_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joniaranguri.resumeapp.common.HtmlCustomText
import com.joniaranguri.resumeapp.common.ImageCard
import com.joniaranguri.resumeapp.common.ShimmerText
import com.joniaranguri.resumeapp.model.Skill
import com.joniaranguri.resumeapp.ui.theme.accentColor

@Composable
fun WorkDetailScreen(
    workId: String,
    goBack: () -> Unit,
    viewModel: WorkDetailViewModel = hiltViewModel()
) {
    val workDetailSection by viewModel.workDetailSection
    val isLoading by viewModel.isLoading
    LaunchedEffect(Unit) { viewModel.initialize(workId) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 32.dp) //Todo: make same in all screens
        ) {
            item {
                SmallTopAppBar(
                    title = {},
                    navigationIcon = {
                        IconButton(
                            onClick = { viewModel.processEvent(goBack) },
                            colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onBackground)
                        ) {
                            Icon(Icons.Filled.ArrowBack, "Go back")
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Column(
                    ) {
                        if (isLoading)
                            ShimmerText(lines = 3)
                        else {
                            Text(
                                text = workDetailSection.title,
                                style = MaterialTheme.typography.titleLarge,
                            )
                            Text(
                                text = workDetailSection.companyName,
                                style = MaterialTheme.typography.titleLarge,
                                color = accentColor
                            )
                            Text(
                                text = workDetailSection.period,
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }
                    }
                    if (isLoading) ShimmerText(lines = 10)
                    else HtmlCustomText(workDetailSection.description)
                    ImageCard(
                        workDetailSection.imageURL,
                        "Image related to the work at ${workDetailSection.companyName}"
                    )
                    Text(
                        text = "Skills",
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
            item {
                SkillsList(workDetailSection.skillsList)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsList(skillsList: List<Skill>) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        LazyRow(contentPadding = PaddingValues(horizontal = 12.dp)) {
            item {
                FlowRow(
                    maxItemsInEachRow = (skillsList.size / 2)
                ) {
                    skillsList.forEach { skill ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.onTertiary)

                        ) {
                            Text(
                                text = skill.name,
                                style = MaterialTheme.typography.titleSmall,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .wrapContentWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}
