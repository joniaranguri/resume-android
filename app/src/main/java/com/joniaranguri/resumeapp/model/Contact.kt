package com.joniaranguri.resumeapp.model

data class Contact(
    val description: String,
    val phoneNumber: String,
    val message: String,
    val socialList: List<Social>
)

data class Social(val name: String, val logo: String, val targetUrl: String)