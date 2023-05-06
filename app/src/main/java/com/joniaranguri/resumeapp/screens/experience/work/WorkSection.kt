package com.joniaranguri.resumeapp.screens.experience.work

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.WorkCard
import com.joniaranguri.resumeapp.model.valuesList
import com.joniaranguri.resumeapp.model.worksList


@Composable
fun WorkSection(openScreen: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
        )
        worksList.forEach { WorkCard(it, openScreen) }
    }
}
