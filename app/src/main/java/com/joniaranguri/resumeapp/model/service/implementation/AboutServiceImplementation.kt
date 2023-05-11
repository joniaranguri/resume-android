package com.joniaranguri.resumeapp.model.service.implementation

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.joniaranguri.resumeapp.model.HobbiesSection
import com.joniaranguri.resumeapp.model.ProfileSection
import com.joniaranguri.resumeapp.model.ValuesSection
import com.joniaranguri.resumeapp.model.service.AboutService
import com.joniaranguri.resumeapp.model.service.module.FirebaseModule.getBaseCollection
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AboutServiceImplementation @Inject constructor(private val firestore: FirebaseFirestore) :
    AboutService {
    override suspend fun getProfileSection(): ProfileSection? =
        firestore.getBaseCollection().document(PROFILE_SECTION).get().await()
            .toObject()

    override suspend fun getValuesSection(): ValuesSection? =
        firestore.getBaseCollection().document(VALUES_SECTION).get().await().toObject()

    override suspend fun getHobbiesSection(): HobbiesSection? =
        firestore.getBaseCollection().document(HOBBIES_SECTION).get().await().toObject()

    companion object {
        private const val PROFILE_SECTION = "profile_section"
        private const val VALUES_SECTION = "values_sections"
        private const val HOBBIES_SECTION = "hobbies_section"
    }
}
