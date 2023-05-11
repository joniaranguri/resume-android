package com.joniaranguri.resumeapp.model.service

import com.joniaranguri.resumeapp.model.*

interface WorkDetailService {
    suspend fun getWorkDetailSection(workId: String): WorkDetailSection?
}