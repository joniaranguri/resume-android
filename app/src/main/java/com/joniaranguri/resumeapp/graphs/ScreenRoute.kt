package com.joniaranguri.resumeapp.graphs

sealed class ScreenRoute(val route: String) {
    object HomeRoot : ScreenRoute("ROOT")
    object About : ScreenRoute("HOME")
    object Education : ScreenRoute("EDUCATION")
    object Experience : ScreenRoute("EXPERIENCE")
    object Contact : ScreenRoute("CONTACT")
}