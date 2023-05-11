package com.joniaranguri.resumeapp.model.service.module

import com.joniaranguri.resumeapp.model.service.WorkDetailService
import com.joniaranguri.resumeapp.model.service.implementation.WorkDetailServiceImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WorkDetailServiceModule {
    @Binds
    abstract fun provideWorkDetailService(impl: WorkDetailServiceImplementation): WorkDetailService
}
