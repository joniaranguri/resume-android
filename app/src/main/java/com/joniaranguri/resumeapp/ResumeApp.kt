package com.joniaranguri.resumeapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.ui.theme.ResumeAppTheme

@Composable
@Preview
fun ResumeApp() {
  ResumeAppTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
     Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
       Text(text = "Welcome to JoniAranguri Resume",
         textAlign = TextAlign.Center,
         modifier = Modifier
           .fillMaxWidth()
           .padding(all = 32.dp),
         style = typography.titleLarge,
       )
       Button(onClick = { /*TODO*/ },
       modifier = Modifier.fillMaxWidth().padding(16.dp)) {
         Text(text = "Start!")
       }
     }
    }
  }
}
