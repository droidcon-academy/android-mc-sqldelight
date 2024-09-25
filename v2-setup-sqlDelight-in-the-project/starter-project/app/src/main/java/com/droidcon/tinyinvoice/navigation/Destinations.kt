package com.droidcon.tinyinvoice.navigation

sealed class Destinations(val route: String) {
    data object InvoiceListScreen : Destinations("InvoiceListScreen")
    data class AddInvoiceItemScreen(val invoice: String = "invoice") :
        Destinations("AddInvoiceItemScreen")

    data object SelectBusinessScreen : Destinations("SelectBusinessScreen")
    data class SelectCustomerScreen(val invoice: String = "invoice") :
        Destinations("SelectCustomerScreen")

    data class SelectTaxScreen(val invoice: String = "invoice") : Destinations("SelectTaxScreen")
    data object BusinessListScreen : Destinations("BusinessListScreen")
    data object AddBusinessScreen : Destinations("AddBusinessScreen")
    data object CustomerListScreen : Destinations("CustomerListScreen")
    data object AddCustomerScreen : Destinations("AddCustomerScreen")
    data object TaxListScreen : Destinations("TaxListScreen")
    data object AddTaxScreen : Destinations("AddTaxScreen")
}