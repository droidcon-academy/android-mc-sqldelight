package com.droidcon.sqldelightmastercourse.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.sqldelightmastercourse.navigation.Destinations
import com.droidcon.sqldelightmastercourse.ui.business.BusinessListRoute

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