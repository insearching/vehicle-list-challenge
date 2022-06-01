package com.freenow.vehicles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.freenow.vehicles.vehicledetails.ui.VehicleDetailsScreen
import com.freenow.vehicles.vehiclelist.ui.VehicleListScreen

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.List.route) {
        val navActions = NavActions(ScreenNavigator(navController))
        addScreen(Screen.Details) { VehicleDetailsScreen(navActions::pop) }
        addScreen(Screen.List) { VehicleListScreen(navActions::goToDetails) }
    }
}
