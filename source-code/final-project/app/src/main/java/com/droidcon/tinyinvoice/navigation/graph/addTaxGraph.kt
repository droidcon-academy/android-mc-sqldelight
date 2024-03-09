package com.droidcon.tinyinvoice.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.ui.tax.AddTaxRoute

fun NavGraphBuilder.addTaxGraph() {
    composable(Destinations.AddTaxScreen.route) {
        AddTaxRoute()
    }
}