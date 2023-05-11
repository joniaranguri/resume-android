package com.joniaranguri.resumeapp.model

data class ContactSection(
    val description: String = "",
    val phoneNumber: String = "",
    val message: String = "",
    val socialList: List<Social> = emptyList()
)

data class Social(val name: String = "", val logo: String = "", val targetUrl: String = "")