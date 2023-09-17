package com.joniaranguri.resumeapp.screens.work_detail

import androidx.compose.runtime.mutableStateOf
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.ktx.setCustomKeys
import com.google.firebase.ktx.Firebase
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
            workDetailService.getWorkDetailSection(workId).also {
                workDetailSection.value = it ?: WorkDetailSection()
                isLoading.value = false
                if (it == null || it.description.isEmpty()) {
                    Firebase.crashlytics.setCustomKeys {
                        key("Workd id", workId)
                    }
                    it?.let {
                        Firebase.crashlytics.setCustomKeys {
                            key("Company name", it.companyName)
                            key("Work title", it.title)
                            key("Work period", it.period)
                        }
                    }
                    throw Throwable(NO_WORK_DESCRIPTION_LOADED)
                }
            }
        }
    }

    fun processEvent(event: () -> Unit) {
        if (now - lastEventTimeMs >= 300L) {
            event.invoke()
        }
        lastEventTimeMs = now
    }

    companion object {
        const val NO_WORK_DESCRIPTION_LOADED =
            "There was an error and no work description was loaded"
    }
}