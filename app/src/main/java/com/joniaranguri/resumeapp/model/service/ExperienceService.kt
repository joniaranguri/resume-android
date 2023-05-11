package com.joniaranguri.resumeapp.model.service

import com.joniaranguri.resumeapp.model.*

interface ExperienceService {
    suspend fun getWorkSection(): WorkSection?
    suspend fun getEducationSection(): EducationSection?
    suspend fun getLanguagesSection(): LanguagesSection?
}