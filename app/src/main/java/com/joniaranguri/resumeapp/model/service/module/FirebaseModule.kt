package com.joniaranguri.resumeapp.model.service.module

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.joniaranguri.resumeapp.model.service.implementation.ProjectsServiceImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    private const val SECTION_COLLECTION = "sections"

    @Provides
    fun firestore(): FirebaseFirestore = Firebase.firestore

    fun FirebaseFirestore.getBaseCollection(): CollectionReference =
        firestore().collection(SECTION_COLLECTION)

}
