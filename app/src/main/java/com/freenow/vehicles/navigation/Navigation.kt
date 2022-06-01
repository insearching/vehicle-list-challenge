package com.freenow.vehicles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


sealed class Screen(val route: String) {
    object List : Screen("list")
    object Details : Screen("details")
}


class NavActions(private val navigator: ScreenNavigator) {
    fun goToList() = navigator.navigate(Screen.List)
    fun goToDetails() = navigator.navigate(Screen.Details)
    fun pop() = navigator.pop()
}

class ScreenNavigator(private val navController: NavController) {
    fun navigate(screen: Screen) = navController.navigate(screen.route)
    fun pop() = navController.popBackStack()
}

fun NavGraphBuilder.addScreen(screen: Screen, content: @Composable (NavBackStackEntry) -> Unit) = composable(screen.route) { content(it) }
