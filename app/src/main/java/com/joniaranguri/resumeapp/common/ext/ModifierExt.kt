package com.joniaranguri.resumeapp.common.ext

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.defaultPadding(): Modifier = this.padding(16.dp)
fun Modifier.paddingEnd(): Modifier = this.padding(bottom = 32.dp)
