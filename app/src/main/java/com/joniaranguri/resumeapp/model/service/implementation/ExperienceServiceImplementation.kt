package com.joniaranguri.resumeapp.model.service.implementation

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.joniaranguri.resumeapp.model.EducationSection
import com.joniaranguri.resumeapp.model.LanguagesSection
import com.joniaranguri.resumeapp.model.WorkSection
import com.joniaranguri.resumeapp.model.service.ExperienceService
import com.joniaranguri.resumeapp.model.service.module.FirebaseModule.getBaseCollection
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ExperienceServiceImplementation @Inject constructor(private val firestore: FirebaseFirestore) :
    ExperienceService {
    override suspend fun getWorkSection(): WorkSection? =
        firestore.getBaseCollection().document(WORK_SECTION).get().await()
            .toObject()

    override suspend fun getEducationSection(): EducationSection? =
        firestore.getBaseCollection().document(EDUCATION_SECTION).get().await().toObject()

    override suspend fun getLanguagesSection(): LanguagesSection? =
        firestore.getBaseCollection().document(LANGUAGES_SECTION).get().await().toObject()


    companion object {
        private const val WORK_SECTION = "work_section"
        private const val EDUCATION_SECTION = "education_section"
        private const val LANGUAGES_SECTION = "languages_section"
    }
}
