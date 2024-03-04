package com.droidcon.sqldelightmastercourse.navigation.graph

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.sqldelightmastercourse.domain.model.Invoice
import com.droidcon.sqldelightmastercourse.navigation.Destinations
import com.droidcon.sqldelightmastercourse.navigation.extensionfunction.navigate
import com.droidcon.sqldelightmastercourse.navigation.extensionfunction.parcelableData
import com.droidcon.sqldelightmastercourse.ui.invoice.addinvoice.SelectCustomerRoute

fun NavGraphBuilder.selectCustomerGraph(
    navController: NavController,
) {
    composable(Destinations.SelectCustomerScreen().route) { entry ->
        val invoice = entry.parcelableData<Invoice>(Destinations.SelectCustomerScreen().invoice)
        SelectCustomerRoute(
            onNavigateToSelectTaxScreen = {
                val newInvoice = invoice?.copy(customerId = it)
                navController.navigate(
                    route = Destinations.SelectTaxScreen().route,
                    args = bundleOf(Destinations.SelectTaxScreen().invoice to newInvoice),
                )
            }
        )
    }
}