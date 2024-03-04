package com.droidcon.sqldelightmastercourse.domain.model

data class InvoiceItem(
    val id: Long,
    val desc: String,
    val qty: Double,
    val price: Double,
    val invoiceId: Long,
) {

    val amount: Double
        get() = qty * price
}