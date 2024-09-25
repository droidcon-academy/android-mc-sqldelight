package com.droidcon.tinyinvoice.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.ui.invoice.InvoiceListRoute

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