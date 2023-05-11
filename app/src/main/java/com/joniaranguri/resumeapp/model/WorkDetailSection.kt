package com.joniaranguri.resumeapp.model

data class WorkDetailSection(
    val companyName: String = "",
    val title: String = "",
    val period: String = "",
    val description: String = "",
    val imageURL: String = "",
    val skillsList: List<Skill> = emptyList()
)

data class Skill(val name: String = "", val icon: String = "")