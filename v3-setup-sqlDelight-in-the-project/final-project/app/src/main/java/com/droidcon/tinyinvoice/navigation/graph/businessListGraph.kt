package com.droidcon.tinyinvoice.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.ui.business.BusinessListRoute

fun NavGraphBuilder.businessListGraph(
    navController: NavController
) {
    composable(Destinations.BusinessListScreen.route) {
        BusinessListRoute(
            onNavigateToAddBusinessScreen = {
                navController.navigate(route = Destinations.AddBusinessScreen.route)
            }
        )
    }
}