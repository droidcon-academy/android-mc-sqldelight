package com.droidcon.tinyinvoice.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.droidcon.tinyinvoice.navigation.graph.addBusinessGraph
import com.droidcon.tinyinvoice.navigation.graph.addCustomerGraph
import com.droidcon.tinyinvoice.navigation.graph.addInvoiceGraph
import com.droidcon.tinyinvoice.navigation.graph.addTaxGraph
import com.droidcon.tinyinvoice.navigation.graph.businessListGraph
import com.droidcon.tinyinvoice.navigation.graph.customerListGraph
import com.droidcon.tinyinvoice.navigation.graph.invoiceListGraph
import com.droidcon.tinyinvoice.navigation.graph.selectBusinessGraph
import com.droidcon.tinyinvoice.navigation.graph.selectCustomerGraph
import com.droidcon.tinyinvoice.navigation.graph.selectTaxGraph
import com.droidcon.tinyinvoice.navigation.graph.taxListGraph

@Composable
fun TinyInvoiceNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.InvoiceListScreen.route,
        modifier = modifier,
    ) {
        invoiceListGraph(navController)
        businessListGraph(navController)
        customerListGraph(navController)
        taxListGraph(navController)
        addBusinessGraph()
        addCustomerGraph()
        addTaxGraph()
        addInvoiceGraph(navController)
        selectBusinessGraph(navController)
        selectCustomerGraph(navController)
        selectTaxGraph(navController)
    }
}