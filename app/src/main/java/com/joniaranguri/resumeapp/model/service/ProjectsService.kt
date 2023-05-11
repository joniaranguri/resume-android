package com.joniaranguri.resumeapp.model.service

import com.joniaranguri.resumeapp.model.*

interface ProjectsService {
    suspend fun getProjectsSection(): ProjectsSection?
}