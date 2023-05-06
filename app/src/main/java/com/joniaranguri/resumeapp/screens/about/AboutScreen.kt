package com.joniaranguri.resumeapp.screens.about

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.screens.about.hobbies.HobbiesSection
import com.joniaranguri.resumeapp.screens.about.profile.ProfileSection
import com.joniaranguri.resumeapp.screens.about.values.ValuesSection
import com.joniaranguri.resumeapp.ui.theme.accentColor

@Composable
fun AboutScreen() {
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
                        text = "This is me,", style = MaterialTheme.typography.titleLarge,
                    )
                    Text(
                        text = "Jonathan Aranguri",
                        style = MaterialTheme.typography.titleLarge,
                        color = accentColor
                    )
                }

            }
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    ProfileSection()
                    ValuesSection()
                }

            }
            item {
                HobbiesSection()
            }
        }
    }
}