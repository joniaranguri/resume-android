package com.joniaranguri.resumeapp.screens.contact

import android.os.Bundle
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.perf.metrics.AddTrace
import com.joniaranguri.resumeapp.ResumeApplication
import com.joniaranguri.resumeapp.model.ContactSection
import com.joniaranguri.resumeapp.model.Message
import com.joniaranguri.resumeapp.model.service.ContactService
import com.joniaranguri.resumeapp.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val contactService: ContactService
) : BaseViewModel() {
    val contactSection = mutableStateOf(ContactSection())

    init {
        launchCatching {
            initContactSection()
        }
    }

    @AddTrace(name = "Contact section init")
    private suspend fun initContactSection() {
        contactService.getContactSection().also {
            contactSection.value = it ?: ContactSection()
            isLoading.value = false
            if (it == null || it.socialList.isEmpty()) throw Throwable(NO_SOCIAL_CONTACT_LOADED)
        }
    }

    fun sendMessage(): Boolean {
        val message = contactSection.value.message
        if (message.isEmpty()) return false
        launchCatching {
            contactService.saveMessage(Message(message))
        }
        FirebaseAnalytics.getInstance(ResumeApplication.instance)
            .logEvent(ANALYTICS_EVENT_SEND_MESSAGE, Bundle().apply {
                putString("message", message)
            })
        return true
    }

    fun onMessageChange(newValue: String) {
        contactSection.value = contactSection.value.copy(message = newValue)
    }

    companion object {
        const val NO_SOCIAL_CONTACT_LOADED = "There was an error and no social contact was loaded"
        const val ANALYTICS_EVENT_SEND_MESSAGE = "SEND_MESSAGE"
        const val ANALYTICS_EVENT_SOCIAL_ITEM = "SOCIAL_ITEM"
    }
}