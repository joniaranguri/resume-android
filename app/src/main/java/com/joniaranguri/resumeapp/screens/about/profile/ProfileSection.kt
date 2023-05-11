package com.joniaranguri.resumeapp.screens.about.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.HtmlCustomText
import com.joniaranguri.resumeapp.common.ImageCard
import com.joniaranguri.resumeapp.common.ShimmerText
import com.joniaranguri.resumeapp.model.ProfileSection

@Composable
fun ProfileSection(profileSection: ProfileSection, isLoading: Boolean) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        ImageCard(
            profileSection.imageURL,
            "Jonathan Aranguri's photo"
        )
        if (isLoading) ShimmerText()
        else HtmlCustomText(profileSection.presentation)
    }
}
