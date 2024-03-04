package com.droidcon.sqldelightmastercourse.domain.model_provider

import com.droidcon.sqldelightmastercourse.domain.model.Invoice
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceWithItems


val invoiceList = listOf(
    InvoiceWithItems(
        invoice = Invoice(-1, -1, -1, -1),
        business = businessList.random(),
        customer = customerList.random(),
        tax = taxList.random(),
    ),
    InvoiceWithItems(
        invoice = Invoice(-2, -1, -1, -1),
        business = businessList.random(),
        customer = customerList.random(),
        tax = taxList.random(),
    ),
    InvoiceWithItems(
        invoice = Invoice(-3, -1, -1, -1),
        business = businessList.random(),
        customer = customerList.random(),
        tax = taxList.random(),
    ),
)
