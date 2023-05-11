package com.joniaranguri.resumeapp.model.service

import com.joniaranguri.resumeapp.model.ContactSection
import com.joniaranguri.resumeapp.model.Message

interface ContactService {
    suspend fun getContactSection(): ContactSection?
    suspend fun saveMessage(message: Message)
}