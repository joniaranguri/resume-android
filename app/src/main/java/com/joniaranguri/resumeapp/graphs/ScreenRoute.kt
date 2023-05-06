package com.joniaranguri.resumeapp.graphs

sealed class ScreenRoute(val route: String) {
    object HomeRoot : ScreenRoute("ROOT")
    object About : ScreenRoute("HOME")
    object Experience : ScreenRoute("EXPERIENCE")
    object Projects : ScreenRoute("PROJECTS")
    object Contact : ScreenRoute("CONTACT")
    object WorkDetail : ScreenRoute("WORK_DETAIL")
}

sealed class NavArgument(val id: String, val default: String) {
    object WorkDetailArgument : NavArgument("WORK_ID", "NONE")
}