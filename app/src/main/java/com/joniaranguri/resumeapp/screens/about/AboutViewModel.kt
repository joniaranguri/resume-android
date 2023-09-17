package com.joniaranguri.resumeapp.screens.about

import androidx.compose.runtime.mutableStateOf
import com.joniaranguri.resumeapp.model.HobbiesSection
import com.joniaranguri.resumeapp.model.ProfileSection
import com.joniaranguri.resumeapp.model.ValuesSection
import com.joniaranguri.resumeapp.model.service.AboutService
import com.joniaranguri.resumeapp.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
            aboutService.getProfileSection().also {
                profileSection.value = it ?: ProfileSection()
                isLoading.value = false
                if (it == null || it.presentation.isEmpty()) throw Throwable(NO_PRESENTATION_LOADED)
            }
        }
        launchCatching {
            aboutService.getValuesSection().also {
                valuesSection.value = it ?: ValuesSection()
                if (it == null || it.valuesList.isEmpty()) throw Throwable(NO_VALUES_LOADED)
            }
        }
        launchCatching {
            hobbiesSection.value = aboutService.getHobbiesSection() ?: HobbiesSection()
            aboutService.getHobbiesSection().also {
                hobbiesSection.value = it ?: HobbiesSection()
                if (it == null || it.hobbiesList.isEmpty()) throw Throwable(NO_HOBBIES_LOADED)
            }
        }
    }

    companion object {
        const val NO_PRESENTATION_LOADED = "There was an error and no presentation was loaded"
        const val NO_VALUES_LOADED = "There was an error and no value was loaded"
        const val NO_HOBBIES_LOADED = "There was an error and no hobby was loaded"
    }
}