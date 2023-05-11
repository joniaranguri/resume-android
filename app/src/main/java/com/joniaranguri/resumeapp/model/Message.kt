package com.joniaranguri.resumeapp.model

data class Message(val message: String, val time: String = java.util.Date().time.toString())
