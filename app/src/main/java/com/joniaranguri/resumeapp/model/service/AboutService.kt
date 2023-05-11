package com.joniaranguri.resumeapp.model.service

import com.joniaranguri.resumeapp.model.*

interface AboutService {
    suspend fun getProfileSection():ProfileSection?
    suspend fun getValuesSection(): ValuesSection?
    suspend fun getHobbiesSection(): HobbiesSection?
}