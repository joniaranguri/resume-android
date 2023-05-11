package com.joniaranguri.resumeapp.model

data class WorkSection(val description: String = "", val workList: List<Work> = emptyList())
data class Work(
    val companyName: String = "",
    val title: String = "",
    val period: String = "",
    val companyLogo: String = ""
)
