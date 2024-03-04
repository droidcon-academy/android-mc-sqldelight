package com.droidcon.sqldelightmastercourse.navigation.graph

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.sqldelightmastercourse.domain.model.Invoice
import com.droidcon.sqldelightmastercourse.navigation.Destinations
import com.droidcon.sqldelightmastercourse.navigation.extensionfunction.navigate
import com.droidcon.sqldelightmastercourse.navigation.extensionfunction.parcelableData
import com.droidcon.sqldelightmastercourse.ui.invoice.addinvoice.SelectTaxRoute

fun NavGraphBuilder.selectTaxGraph(
    navController: NavController,
) {
    composable(Destinations.SelectTaxScreen().route) { entry ->
        val invoice = entry.parcelableData<Invoice>(Destinations.SelectTaxScreen().invoice)
        SelectTaxRoute(
            onNavigateToAddInvoiceItemScreen = {
                val newInvoice = invoice?.copy(taxId = it)
                navController.navigate(
                    route = Destinations.AddInvoiceItemScreen().route,
                    args = bundleOf(Destinations.AddInvoiceItemScreen().invoice to newInvoice),
                )
            }
        )
    }
}