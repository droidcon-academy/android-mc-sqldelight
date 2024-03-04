package com.droidcon.sqldelightmastercourse.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.droidcon.sqldelightmastercourse.navigation.graph.addBusinessGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.addCustomerGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.addInvoiceGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.addTaxGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.businessListGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.customerListGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.invoiceListGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.selectBusinessGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.selectCustomerGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.selectTaxGraph
import com.droidcon.sqldelightmastercourse.navigation.graph.taxListGraph

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