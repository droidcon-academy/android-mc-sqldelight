package com.droidcon.tinyinvoice.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.ui.customer.CustomerListRoute

fun NavGraphBuilder.customerListGraph(
    navController: NavController
) {
    composable(Destinations.CustomerListScreen.route) {
        CustomerListRoute(
            onNavigateToAddCustomerScreen = {
                navController.navigate(route = Destinations.AddCustomerScreen.route)
            }
        )
    }
}