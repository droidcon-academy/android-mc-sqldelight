package com.droidcon.tinyinvoice.navigation.graph

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.domain.model.Invoice
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.navigation.extensionfunction.navigate
import com.droidcon.tinyinvoice.ui.invoice.addinvoice.SelectBusinessRoute

fun NavGraphBuilder.selectBusinessGraph(
    navController: NavController,
) {
    composable(Destinations.SelectBusinessScreen.route) {
        SelectBusinessRoute(
            onNavigateToSelectCustomerScreen = { businessId ->
                val invoice = Invoice(
                    id = -1L,
                    businessId = businessId,
                    customerId = -1L,
                    taxId = -1L,
                )
                navController.navigate(
                    route = Destinations.SelectCustomerScreen().route,
                    args = bundleOf(Destinations.SelectCustomerScreen().invoice to invoice)
                )
            }
        )
    }
}