package com.joniaranguri.resumeapp.model

data class HobbiesSection(val hobbiesList: List<Hobby> = emptyList())
data class Hobby(
    val name: String = "",
    val description: String = "",
    val imageURL: String = "",
    val color: String = ""
)