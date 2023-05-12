package com.joniaranguri.resumeapp.screens.about

import androidx.compose.runtime.mutableStateOf
import com.joniaranguri.resumeapp.model.*
import com.joniaranguri.resumeapp.model.service.AboutService
import com.joniaranguri.resumeapp.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(
    private val aboutService: AboutService
) : BaseViewModel() {
    val profileSection = mutableStateOf(ProfileSection())
    val valuesSection = mutableStateOf(ValuesSection())
    val hobbiesSection = mutableStateOf(HobbiesSection())

    init {
        launchCatching {
            profileSection.value = aboutService.getProfileSection() ?: ProfileSection()
            isLoading.value = false
        }
        launchCatching {
            valuesSection.value = aboutService.getValuesSection() ?: ValuesSection()
        }
        launchCatching {
            hobbiesSection.value = aboutService.getHobbiesSection() ?: HobbiesSection()
        }
    }

}