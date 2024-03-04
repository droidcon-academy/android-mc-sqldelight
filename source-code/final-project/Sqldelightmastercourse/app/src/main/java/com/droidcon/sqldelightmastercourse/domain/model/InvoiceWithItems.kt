package com.droidcon.sqldelightmastercourse.domain.model

data class InvoiceWithItems(
    val invoice: Invoice,
    val business: Business,
    val customer: Customer,
    val tax: Tax,
)