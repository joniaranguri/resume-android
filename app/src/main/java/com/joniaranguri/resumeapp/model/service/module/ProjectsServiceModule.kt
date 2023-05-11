package com.joniaranguri.resumeapp.model.service.module

import com.joniaranguri.resumeapp.model.service.ProjectsService
import com.joniaranguri.resumeapp.model.service.implementation.ProjectsServiceImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProjectsServiceModule {
    @Binds
    abstract fun provideProjectsService(impl: ProjectsServiceImplementation): ProjectsService
}
