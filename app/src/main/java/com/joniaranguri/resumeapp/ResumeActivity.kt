package com.joniaranguri.resumeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ResumeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ResumeApp() }
    }
}