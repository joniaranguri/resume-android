package com.joniaranguri.resumeapp.screens.experience

import androidx.compose.runtime.mutableStateOf
import com.google.firebase.perf.metrics.AddTrace
import com.joniaranguri.resumeapp.model.EducationSection
import com.joniaranguri.resumeapp.model.LanguagesSection
import com.joniaranguri.resumeapp.model.Project
import com.joniaranguri.resumeapp.model.Work
import com.joniaranguri.resumeapp.model.WorkSection
import com.joniaranguri.resumeapp.model.service.ExperienceService
import com.joniaranguri.resumeapp.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExperienceViewModel @Inject constructor(
    private val experienceService: ExperienceService
) : BaseViewModel() {
    val workSection = mutableStateOf(WorkSection())
    val educationSection = mutableStateOf(EducationSection())
    val languagesSection = mutableStateOf(LanguagesSection())

    init {
        launchCatching {
            initWorkSection()
        }
        launchCatching {
            initEducationSection()
        }
        launchCatching {
            initLanguagesSection()
        }
    }

    @AddTrace(name = "Work section init")
    private suspend fun initWorkSection() {
        experienceService.getWorkSection().also {
            it?.workList = it?.workList?.sortedBy { work: Work -> work.order } ?: emptyList()
            workSection.value = it ?: WorkSection()
            isLoading.value = false
            if (it == null || it.workList.isEmpty()) throw Throwable(NO_WORKS_LOADED)
        }
    }

    @AddTrace(name = "Education section init")

    private suspend fun initEducationSection() {
        experienceService.getEducationSection().also {
            educationSection.value = it ?: EducationSection()
            if (it == null || it.educationList.isEmpty()) throw Throwable(NO_EDUCATION_LOADED)
        }
    }

    @AddTrace(name = "Languages section init")
    private suspend fun initLanguagesSection() {
        experienceService.getLanguagesSection().also {
            languagesSection.value = it ?: LanguagesSection()
            if (it == null || it.languagesList.isEmpty()) throw Throwable(NO_LANGUAGES_LOADED)
        }
    }

    companion object {
        const val NO_WORKS_LOADED = "There was an error and no one job was loaded"
        const val NO_LANGUAGES_LOADED = "There was an error and no one language was loaded"
        const val NO_EDUCATION_LOADED = "There was an error and education was not loaded"
        const val ANALYTICS_EVENT_WORK_DETAIL = "WORK_DETAIL"

    }
}