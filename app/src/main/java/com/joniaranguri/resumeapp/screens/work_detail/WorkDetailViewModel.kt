package com.joniaranguri.resumeapp.screens.work_detail

import androidx.compose.runtime.mutableStateOf
import com.joniaranguri.resumeapp.model.WorkDetailSection
import com.joniaranguri.resumeapp.model.service.WorkDetailService
import com.joniaranguri.resumeapp.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkDetailViewModel @Inject constructor(
    private val workDetailService: WorkDetailService
) : BaseViewModel() {
    val workDetailSection = mutableStateOf(WorkDetailSection())
    private val now: Long
        get() = System.currentTimeMillis()

    private var lastEventTimeMs: Long = 0

    fun initialize(workId: String) {
        launchCatching {
            workDetailSection.value =
                workDetailService.getWorkDetailSection(workId) ?: WorkDetailSection()
            isLoading.value = false
        }
    }

    fun processEvent(event: () -> Unit) {
        if (now - lastEventTimeMs >= 300L) {
            event.invoke()
        }
        lastEventTimeMs = now
    }
}