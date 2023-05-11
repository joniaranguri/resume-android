package com.joniaranguri.resumeapp.model.service.implementation

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.joniaranguri.resumeapp.model.ProjectsSection
import com.joniaranguri.resumeapp.model.service.ProjectsService
import com.joniaranguri.resumeapp.model.service.module.FirebaseModule.getBaseCollection
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProjectsServiceImplementation @Inject constructor(private val firestore: FirebaseFirestore) :
    ProjectsService {
    override suspend fun getProjectsSection(): ProjectsSection? =
        firestore.getBaseCollection().document(PROJECTS_SECTION).get().await().toObject()

    companion object {
        private const val PROJECTS_SECTION = "projects_section"
    }
}
