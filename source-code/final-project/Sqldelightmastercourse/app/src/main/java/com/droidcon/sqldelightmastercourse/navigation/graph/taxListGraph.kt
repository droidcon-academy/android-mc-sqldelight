package com.droidcon.sqldelightmastercourse.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.sqldelightmastercourse.navigation.Destinations
import com.droidcon.sqldelightmastercourse.ui.tax.TaxListRoute

fun NavGraphBuilder.taxListGraph(
    navController: NavController
) {
    composable(Destinations.TaxListScreen.route) {
        TaxListRoute(
            onNavigationToAddTaxScreen = {
                navController.navigate(route = Destinations.AddTaxScreen.route)
            }
        )
    }
}