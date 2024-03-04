package com.droidcon.sqldelightmastercourse.navigation

import com.droidcon.sqldelightmastercourse.R

val navigationItems = listOf(
    BottomNavItem(
        name = "Invoice",
        route = Destinations.InvoiceListScreen.route,
        icon = R.drawable.ic_invoices,
    ),
    BottomNavItem(
        name = "Business",
        route = Destinations.BusinessListScreen.route,
        icon = R.drawable.ic_my_businesses,
    ),
    BottomNavItem(
        name = "Customer",
        route = Destinations.CustomerListScreen.route,
        icon = R.drawable.ic_customers,
    ),
    BottomNavItem(
        name = "Tax",
        route = Destinations.TaxListScreen.route,
        icon = R.drawable.ic_taxes,
    ),
)