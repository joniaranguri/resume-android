package com.joniaranguri.resumeapp.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.joniaranguri.resumeapp.ui.theme.CeraPro
import de.charlex.compose.HtmlText

@Composable
fun HtmlCustomText(text: String, modifier: Modifier = Modifier) {
    HtmlText(
        modifier = modifier,
        text = text,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = .5.sp,
        fontFamily = CeraPro, color = MaterialTheme.colorScheme.onBackground
    )
}