package com.droidcon.tinyinvoice.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.ui.customer.AddCustomerRoute

fun NavGraphBuilder.addCustomerGraph() {
    composable(Destinations.AddCustomerScreen.route) {
        AddCustomerRoute()
    }
}