package com.droidcon.tinyinvoice.data.local.mapper

import com.droidcon.db.InvoiceItemEntity
import com.droidcon.tinyinvoice.domain.model.InvoiceItem

fun InvoiceItemEntity.toInvoiceItem(): InvoiceItem =
    InvoiceItem(
        id = id,
        desc = desc,
        qty = qty,
        price = price,
        invoiceId = invoiceId,
    )
