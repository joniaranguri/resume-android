package com.joniaranguri.resumeapp.model

data class LanguagesSection(
    val description: String = "",
    val languagesList: List<Language> = emptyList()
)
data class Language(
    val name: String = "",
    val level: String = "",
    val imageURL: String = "",
    val color: String = ""
)