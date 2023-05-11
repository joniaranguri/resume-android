package com.joniaranguri.resumeapp.screens.projects

import androidx.compose.runtime.mutableStateOf
import com.joniaranguri.resumeapp.model.ProjectsSection
import com.joniaranguri.resumeapp.model.service.ProjectsService
import com.joniaranguri.resumeapp.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor(
    private val projectsService: ProjectsService
) : BaseViewModel() {
    val projectsSection = mutableStateOf(ProjectsSection())

    fun initialize() {
        launchCatching {
            projectsSection.value = projectsService.getProjectsSection() ?: ProjectsSection()
        }
    }
}