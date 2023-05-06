package com.joniaranguri.resumeapp.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joniaranguri.resumeapp.screens.about.AboutScreen
import com.joniaranguri.resumeapp.screens.DummyContent

fun NavGraphBuilder.resumeNavGraph() {
        composable(route = ScreenRoute.About.route) {
            AboutScreen()
        }
        composable(route = ScreenRoute.Education.route) {
            DummyContent(name = ScreenRoute.Education.route, onClick = { })
        }
        composable(route = ScreenRoute.Experience.route) {
            DummyContent(name = ScreenRoute.Experience.route, onClick = { })
        }
        composable(route = ScreenRoute.Contact.route) {
            DummyContent(name = ScreenRoute.Contact.route, onClick = { })
        }
}