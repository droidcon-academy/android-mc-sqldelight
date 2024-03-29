package com.droidcon.tinyinvoice.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.domain.model.Invoice
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.navigation.extensionfunction.parcelableData
import com.droidcon.tinyinvoice.ui.invoice.addinvoice.AddInvoiceItemRoute

fun NavGraphBuilder.addInvoiceGraph(
    navController: NavController,
) {
    composable(Destinations.AddInvoiceItemScreen().route) { entry ->
        val invoice = entry.parcelableData<Invoice>(Destinations.AddInvoiceItemScreen().invoice)
        invoice?.let { notNullInvoice ->
            AddInvoiceItemRoute(
                invoice = notNullInvoice,
                onNavigateToInvoiceListScreen = {
                    navController.navigate(route = Destinations.InvoiceListScreen.route)
                },
            )
        }
    }
}