package com.joniaranguri.resumeapp.model.service.module

import com.joniaranguri.resumeapp.model.service.AboutService
import com.joniaranguri.resumeapp.model.service.implementation.AboutServiceImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AboutServiceModule {
    @Binds
    abstract fun provideStorageService(impl: AboutServiceImplementation): AboutService
}
