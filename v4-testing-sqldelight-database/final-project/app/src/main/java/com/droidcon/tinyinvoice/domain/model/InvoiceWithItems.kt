package com.droidcon.tinyinvoice.domain.model

data class InvoiceWithItems(
    val invoice: Invoice,
    val business: Business,
    val customer: Customer,
    val tax: Tax,
)