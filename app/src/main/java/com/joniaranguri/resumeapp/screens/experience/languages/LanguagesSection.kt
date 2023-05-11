package com.joniaranguri.resumeapp.screens.experience.languages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.HorizontalFeatureItem
import com.joniaranguri.resumeapp.common.ext.paddingEnd
import com.joniaranguri.resumeapp.model.LanguagesSection

@Composable
fun LanguagesSection(languagesSection: LanguagesSection) {
    val languageHeight: Dp = LocalConfiguration.current.screenWidthDp.dp * 27 / 100
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Languages",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            languagesSection.description
        )
    }
    LazyRow(Modifier.paddingEnd()) {
        item {
            Row {
                languagesSection.languagesList.forEach { language ->
                    HorizontalFeatureItem(
                        modifier = Modifier.fillParentMaxWidth(.4f),
                        imageModifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp
                        ),
                        title = language.name,
                        description = language.level,
                        imageURL = language.imageURL,
                        color = language.color,
                        isLoading = false,
                        minImageHeight = languageHeight,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                }
            }
        }
    }
}