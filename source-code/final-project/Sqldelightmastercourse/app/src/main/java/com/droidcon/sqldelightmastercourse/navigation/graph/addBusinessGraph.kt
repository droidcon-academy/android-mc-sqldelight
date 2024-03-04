package com.droidcon.sqldelightmastercourse.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droidcon.sqldelightmastercourse.navigation.Destinations
import com.droidcon.sqldelightmastercourse.ui.business.AddBusinessRoute

fun NavGraphBuilder.addBusinessGraph() {
    composable(Destinations.AddBusinessScreen.route) {
        AddBusinessRoute()
    }
}