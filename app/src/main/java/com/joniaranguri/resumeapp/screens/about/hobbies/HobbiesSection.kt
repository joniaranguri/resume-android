package com.joniaranguri.resumeapp.screens.about.hobbies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.common.HorizontalFeatureItem
import com.joniaranguri.resumeapp.common.ext.defaultPadding
import com.joniaranguri.resumeapp.model.Hobby

@Composable
fun HobbiesSection(hobbiesSectionList: List<Hobby>, isLoading: Boolean) {
    val hobbyHeight: Dp = LocalConfiguration.current.screenWidthDp.dp * 55 / 100
    Column {
        Text(
            modifier = Modifier.defaultPadding(),
            text = "My Hobbies",
            style = MaterialTheme.typography.titleLarge,
        )
        LazyRow {
            item {
                Row {
                    if (isLoading) {
                        repeat(4) {
                            HorizontalFeatureItem(
                                Modifier.fillParentMaxWidth(.6f),
                                Modifier,
                                "placeholder",
                                "placeholder",
                                "",
                                "blueLight", true,
                                hobbyHeight)
                        }
                    } else HobbiesList(
                        hobbiesSectionList, Modifier.fillParentMaxWidth(.6f),
                        hobbyHeight
                    )
                }
            }
        }
    }
}

@Composable
fun HobbiesList(hobbiesSectionList: List<Hobby>, modifier: Modifier, hobbyHeight: Dp) {
    hobbiesSectionList.forEach { hobby ->
        HorizontalFeatureItem(
            modifier,
            Modifier,
            hobby.name,
            hobby.description,
            hobby.imageURL,
            hobby.color, false,
            hobbyHeight
        )
    }
}
