package com.droidcon.tinyinvoice.navigation.graph

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.domain.model.Invoice
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.navigation.extensionfunction.navigate
import com.droidcon.tinyinvoice.navigation.extensionfunction.parcelableData
import com.droidcon.tinyinvoice.ui.invoice.addinvoice.SelectTaxRoute

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