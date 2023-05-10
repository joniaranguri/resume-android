package com.joniaranguri.resumeapp.screens.experience.work

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.WorkCard
import com.joniaranguri.resumeapp.model.workSection


@Composable
fun WorkSection(openScreen: (String) -> Unit) {

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            workSection.description
        )
        workSection.sectionList.forEach { WorkCard(it, openScreen) }
    }
}
