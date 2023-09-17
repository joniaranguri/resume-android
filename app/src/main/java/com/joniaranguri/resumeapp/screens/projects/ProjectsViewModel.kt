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

    init {
        launchCatching {
            projectsService.getProjectsSection().also {
                projectsSection.value = it ?: ProjectsSection()
                isLoading.value = false
                if (it == null || it.projectsList.isEmpty()) throw Throwable(NO_PROJECTS_LOADED)
            }
        }
    }

    companion object {
        const val NO_PROJECTS_LOADED = "There was an error and no one personal project was loaded"
    }
}