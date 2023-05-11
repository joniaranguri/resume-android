package com.joniaranguri.resumeapp.model.service.implementation

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.joniaranguri.resumeapp.model.*
import com.joniaranguri.resumeapp.model.service.AboutService
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AboutServiceImplementation @Inject constructor(private val firestore: FirebaseFirestore) :
    AboutService {
    override suspend fun getProfileSection(): ProfileSection? =
        currentCollection().document(PROFILE_SECTION).get().await()
            .toObject()

    override suspend fun getValuesSection(): ValuesSection? =
        currentCollection().document(VALUES_SECTION).get().await().toObject()

    override suspend fun getHobbiesSection(): HobbiesSection? =
        currentCollection().document(HOBBIES_SECTION).get().await().toObject()

    private fun currentCollection(): CollectionReference = firestore.collection(SECTION_COLLECTION)

    companion object {
        private const val SECTION_COLLECTION = "sections"
        private const val PROFILE_SECTION = "profile_section"
        private const val VALUES_SECTION = "values_sections"
        private const val HOBBIES_SECTION = "hobbies_section"
    }
}
