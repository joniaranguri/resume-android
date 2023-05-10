package com.joniaranguri.resumeapp.screens.about.hobbies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.joniaranguri.resumeapp.common.HorizontalFeatureItem
import com.joniaranguri.resumeapp.common.ext.defaultPadding
import com.joniaranguri.resumeapp.common.ext.paddingEnd
import com.joniaranguri.resumeapp.model.courseList

@Composable
fun HobbiesSection() {
    Column(modifier = Modifier.paddingEnd()) {
        Text(
            modifier = Modifier.defaultPadding(),
            text = "My Hobbies",
            style = MaterialTheme.typography.titleLarge,
        )
        LazyRow {
            item {
                Row {
                    courseList.forEach { hobby ->
                        HorizontalFeatureItem(
                            Modifier.fillParentMaxWidth(.6f),
                            Modifier,
                            hobby.name,
                            hobby.description,
                            hobby.imageURL,
                            hobby.color
                        )
                    }
                }
            }
        }
    }
}
