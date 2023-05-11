package com.joniaranguri.resumeapp.model.service.implementation

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.joniaranguri.resumeapp.model.ContactSection
import com.joniaranguri.resumeapp.model.Message
import com.joniaranguri.resumeapp.model.service.ContactService
import com.joniaranguri.resumeapp.model.service.module.FirebaseModule.getBaseCollection
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ContactServiceImplementation @Inject constructor(private val firestore: FirebaseFirestore) :
    ContactService {
    override suspend fun getContactSection(): ContactSection? =
        firestore.getBaseCollection().document(CONTACT_SECTION).get().await().toObject()

    override suspend fun saveMessage(message: Message) {
        firestore.collection(MESSAGES_COLLECTION).add(message).await()
    }

    companion object {
        private const val CONTACT_SECTION = "contact_section"
        private const val MESSAGES_COLLECTION = "messages"
    }
}
