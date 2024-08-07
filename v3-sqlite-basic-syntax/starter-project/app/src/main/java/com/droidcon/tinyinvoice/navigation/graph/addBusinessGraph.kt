package com.droidcon.tinyinvoice.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.tinyinvoice.navigation.Destinations
import com.droidcon.tinyinvoice.ui.business.AddBusinessRoute

fun NavGraphBuilder.addBusinessGraph() {
    composable(Destinations.AddBusinessScreen.route) {
        AddBusinessRoute()
    }
}