package com.joniaranguri.resumeapp.model.service.module

import com.joniaranguri.resumeapp.model.service.ExperienceService
import com.joniaranguri.resumeapp.model.service.implementation.ExperienceServiceImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ExperienceServiceModule {
    @Binds
    abstract fun provideExperienceService(impl: ExperienceServiceImplementation): ExperienceService
}
