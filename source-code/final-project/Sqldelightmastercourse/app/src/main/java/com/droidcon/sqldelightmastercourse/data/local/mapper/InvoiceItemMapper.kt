package com.droidcon.sqldelightmastercourse.data.local.mapper

import com.droidcon.db.InvoiceItemEntity
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceItem

fun InvoiceItemEntity.toInvoiceItem(): InvoiceItem =
    InvoiceItem(
        id = id,
        desc = desc,
        qty = qty,
        price = price,
        invoiceId = invoiceId,
    )

fun InvoiceItem.toInvoiceItemEntity(): InvoiceItemEntity =
    InvoiceItemEntity(
        id = id,
        desc = desc,
        qty = qty,
        price = price,
        invoiceId = invoiceId,
    )