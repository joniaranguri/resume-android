package com.joniaranguri.resumeapp.screens.experience.languages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.HorizontalFeatureItem
import com.joniaranguri.resumeapp.common.ext.paddingEnd
import com.joniaranguri.resumeapp.model.languagesSection

@Composable
fun LanguagesSection() {
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
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
        )
    }
    LazyRow {
        itemsIndexed(languagesSection.sectionList) { _, language ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.paddingEnd()
            ) {
                HorizontalFeatureItem(
                    modifier = Modifier.fillParentMaxWidth(.4f),
                    imageModifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    imageURL = language.imageURL,
                    color = language.color
                )
                Text(text = language.name, style = MaterialTheme.typography.titleSmall)
                Text(text = language.level, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }

}