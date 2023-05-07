package com.joniaranguri.resumeapp.screens.work_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.ui.theme.accentColor

@Composable
fun WorkDetailScreen(workId: String) {
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
                        text = "Ssr Software Engineer", style = MaterialTheme.typography.titleLarge,
                    )
                    Text(
                        text = workId,
                        style = MaterialTheme.typography.titleLarge,
                        color = accentColor
                    )
                }
            }
        }
    }
}