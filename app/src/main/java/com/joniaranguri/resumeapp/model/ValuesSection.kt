package com.joniaranguri.resumeapp.model

data class ValuesSection(val description: String = "", val valuesList: List<Value> = emptyList())
data class Value(
    val name: String = "",
    val description: String = "",
    val color: String = "",
    val imageUrl: String = ""
)
