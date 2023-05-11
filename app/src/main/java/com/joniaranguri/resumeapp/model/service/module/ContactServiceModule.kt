package com.joniaranguri.resumeapp.model.service.module

import com.joniaranguri.resumeapp.model.service.ContactService
import com.joniaranguri.resumeapp.model.service.implementation.ContactServiceImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ContactServiceModule {
    @Binds
    abstract fun provideProjectsService(impl: ContactServiceImplementation): ContactService
}
