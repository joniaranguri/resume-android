package com.joniaranguri.resumeapp.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Edit
import androidx.compose.material.icons.twotone.MailOutline
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.joniaranguri.resumeapp.graphs.ScreenRoute

@Composable
fun NavigationBottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Experience,
        BottomBarScreen.Education,
        BottomBarScreen.Contact,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar(
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen, currentDestination: NavDestination?, navController: NavHostController
) {
    NavigationBarItem(label = {
        Text(text = screen.title)
    }, icon = {
        Icon(
            imageVector = screen.icon, contentDescription = "Navigation Icon"
        )
    }, selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true, onClick = {
        navController.navigate(screen.route) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    })
}

sealed class BottomBarScreen(
    val route: String, val title: String, val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = ScreenRoute.About.route, title = "Me", icon = Icons.TwoTone.Person
    )

    object Experience : BottomBarScreen(
        route = ScreenRoute.Experience.route, title = "Experience", icon = Icons.TwoTone.Star
    )

    object Education : BottomBarScreen(
        route = ScreenRoute.Projects.route, title = "Projects", icon = Icons.TwoTone.Edit
    )

    object Contact : BottomBarScreen(
        route = ScreenRoute.Contact.route, title = "Contact", icon = Icons.TwoTone.MailOutline
    )
}
