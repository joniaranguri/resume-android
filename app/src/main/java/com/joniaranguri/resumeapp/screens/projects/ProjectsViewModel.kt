package com.joniaranguri.resumeapp.screens.projects

import androidx.compose.runtime.mutableStateOf
import com.google.firebase.perf.metrics.AddTrace
import com.joniaranguri.resumeapp.model.LanguagesSection
import com.joniaranguri.resumeapp.model.Project
import com.joniaranguri.resumeapp.model.ProjectsSection
import com.joniaranguri.resumeapp.model.Work
import com.joniaranguri.resumeapp.model.service.ProjectsService
import com.joniaranguri.resumeapp.screens.base.BaseViewModel
import com.joniaranguri.resumeapp.screens.experience.ExperienceViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor(
    private val projectsService: ProjectsService
) : BaseViewModel() {
    val projectsSection = mutableStateOf(ProjectsSection())

    init {
        launchCatching {
            initProjectsSection()
        }
    }

    @AddTrace(name = "Projects section init")
    private suspend fun initProjectsSection() {
        projectsService.getProjectsSection().also {
            it?.projectsList = it?.projectsList?.sortedBy { project: Project -> project.order } ?: emptyList()
            projectsSection.value = it ?: ProjectsSection()
            isLoading.value = false
            if (it == null || it.projectsList.isEmpty()) throw Throwable(NO_PROJECTS_LOADED)
        }
    }

    companion object {
        const val NO_PROJECTS_LOADED = "There was an error and no one personal project was loaded"
        const val ANALYTICS_EVENT_PROJECT = "PROJECT_DETAIL"
    }
}