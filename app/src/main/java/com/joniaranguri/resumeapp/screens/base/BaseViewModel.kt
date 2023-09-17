package com.joniaranguri.resumeapp.screens.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase


open class BaseViewModel : ViewModel() {
    val isLoading = mutableStateOf(true)
    fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                Firebase.crashlytics.recordException(throwable)
            },
            block = block
        )
}