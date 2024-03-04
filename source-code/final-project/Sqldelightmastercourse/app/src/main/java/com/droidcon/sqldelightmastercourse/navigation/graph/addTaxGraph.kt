package com.droidcon.sqldelightmastercourse.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.sqldelightmastercourse.navigation.Destinations
import com.droidcon.sqldelightmastercourse.ui.tax.AddTaxRoute

fun NavGraphBuilder.addTaxGraph() {
    composable(Destinations.AddTaxScreen.route) {
        AddTaxRoute()
    }
}