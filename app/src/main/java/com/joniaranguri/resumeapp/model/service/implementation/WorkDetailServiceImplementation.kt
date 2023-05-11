package com.joniaranguri.resumeapp.model.service.implementation

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.joniaranguri.resumeapp.model.WorkDetailSection
import com.joniaranguri.resumeapp.model.service.WorkDetailService
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class WorkDetailServiceImplementation @Inject constructor(private val firestore: FirebaseFirestore) :
    WorkDetailService {
    override suspend fun getWorkDetailSection(workId: String): WorkDetailSection? =
        firestore.collection(WORK_DETAILS_COLLECTION).document(workId).get().await().toObject()

    companion object {
        private const val WORK_DETAILS_COLLECTION = "work_details"
    }
}
