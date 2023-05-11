package com.joniaranguri.resumeapp.model

data class EducationSection(
    val description: String="",
    val educationList: List<Education> = emptyList()
)
data class Education(
    val institution: String="",
    val website: String="",
    val career: String="",
    val period: String="",
    val institutionLogo: String=""
)
