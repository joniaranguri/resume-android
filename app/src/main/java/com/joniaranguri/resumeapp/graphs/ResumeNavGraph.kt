package com.joniaranguri.resumeapp.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.joniaranguri.resumeapp.ResumeAppState
import com.joniaranguri.resumeapp.screens.about.AboutScreen
import com.joniaranguri.resumeapp.screens.DummyContent
import com.joniaranguri.resumeapp.screens.experience.ExperienceScreen
import com.joniaranguri.resumeapp.screens.projects.ProjectsScreen
import com.joniaranguri.resumeapp.screens.work_detail.WorkDetailScreen

fun NavGraphBuilder.resumeNavGraph(appState: ResumeAppState) {
    composable(route = ScreenRoute.About.route) {
        AboutScreen()
    }
    composable(route = ScreenRoute.Experience.route) {
        ExperienceScreen(openScreen = { route -> appState.navigate(route) })
    }
    composable(route = ScreenRoute.Projects.route) {
        ProjectsScreen()
    }
    composable(route = ScreenRoute.Contact.route) {
        DummyContent(name = ScreenRoute.Contact.route, onClick = { })
    }
    composable(
        route = "${ScreenRoute.WorkDetail.route}/{${NavArgument.WorkDetailArgument.id}}",
        arguments = listOf(navArgument(NavArgument.WorkDetailArgument.id) {
            defaultValue = NavArgument.WorkDetailArgument.default
        })
    ) {
        WorkDetailScreen(
            workId = it.arguments?.getString(NavArgument.WorkDetailArgument.id)
                ?: NavArgument.WorkDetailArgument.default
        )
    }
}