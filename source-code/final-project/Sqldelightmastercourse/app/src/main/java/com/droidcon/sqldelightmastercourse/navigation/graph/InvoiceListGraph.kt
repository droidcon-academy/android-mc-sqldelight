package com.droidcon.sqldelightmastercourse.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.sqldelightmastercourse.navigation.Destinations
import com.droidcon.sqldelightmastercourse.ui.invoice.InvoiceListRoute

fun NavGraphBuilder.invoiceListGraph(
    navController: NavController,
) {
    composable(Destinations.InvoiceListScreen.route) {
        InvoiceListRoute(
            onNavigateToSelectBusinessScreen = {
                navController.navigate(route = Destinations.SelectBusinessScreen.route)
            }
        )
    }
}