package com.joniaranguri.resumeapp.screens.experience

import androidx.compose.runtime.mutableStateOf
import com.joniaranguri.resumeapp.model.EducationSection
import com.joniaranguri.resumeapp.model.LanguagesSection
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
            workSection.value = experienceService.getWorkSection() ?: WorkSection()
            isLoading.value = false
        }
        launchCatching {
            educationSection.value = experienceService.getEducationSection() ?: EducationSection()
        }
        launchCatching {
            languagesSection.value = experienceService.getLanguagesSection() ?: LanguagesSection()
        }
    }

}