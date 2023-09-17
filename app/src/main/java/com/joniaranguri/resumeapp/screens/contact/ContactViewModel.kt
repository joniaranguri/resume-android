package com.joniaranguri.resumeapp.screens.contact

import androidx.compose.runtime.mutableStateOf
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
            contactService.getContactSection().also {
                contactSection.value = it ?: ContactSection()
                isLoading.value = false
                if (it == null || it.socialList.isEmpty()) throw Throwable(NO_SOCIAL_CONTACT_LOADED)
            }
        }
    }

    fun sendMessage(): Boolean {
        val message = contactSection.value.message
        if (message.isEmpty()) return false
        launchCatching {
            contactService.saveMessage(Message(message))
        }
        return true
    }

    fun onMessageChange(newValue: String) {
        contactSection.value = contactSection.value.copy(message = newValue)
    }

    companion object {
        const val NO_SOCIAL_CONTACT_LOADED = "There was an error and no social contact was loaded"
    }
}