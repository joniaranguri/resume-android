package com.joniaranguri.resumeapp.screens.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf


open class BaseViewModel : ViewModel() {
    val isLoading = mutableStateOf(true)
    fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                // Todo: Make log of errors
            },
            block = block
        )
}