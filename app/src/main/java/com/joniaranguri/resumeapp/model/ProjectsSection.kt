package com.joniaranguri.resumeapp.model

data class ProjectsSection(
    val description: String = "",
    var projectsList: List<Project> = emptyList()
)

data class Project(
    val name: String = "",
    val type: String = "",
    val description: String = "",
    val status: String = "",
    val logo: String = "",
    val url: String = "",
    val order: Int = 0
)
