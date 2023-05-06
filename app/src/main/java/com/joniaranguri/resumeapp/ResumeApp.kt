package com.joniaranguri.resumeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.joniaranguri.resumeapp.common.NavigationBottomBar
import com.joniaranguri.resumeapp.graphs.ScreenRoute
import com.joniaranguri.resumeapp.graphs.resumeNavGraph
import com.joniaranguri.resumeapp.ui.theme.ResumeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ResumeApp() {
    val appState = rememberAppState()
    ResumeAppTheme {
        Scaffold(bottomBar = { NavigationBottomBar(navController = appState.navController) }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(
                    navController = appState.navController,
                    route = ScreenRoute.HomeRoot.route,
                    startDestination = ScreenRoute.About.route
                ) {
                    resumeNavGraph(appState)
                }
            }
        }
    }
}

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) { ResumeAppState(navController) }
