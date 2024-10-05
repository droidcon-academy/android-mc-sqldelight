package com.droidcon.tinyinvoice.data.local.mapper

import com.droidcon.db.GetInvoiceList
import com.droidcon.tinyinvoice.data.local.database.TRUE
import com.droidcon.tinyinvoice.data.utils.orZero
import com.droidcon.tinyinvoice.domain.model.Business
import com.droidcon.tinyinvoice.domain.model.Customer
import com.droidcon.tinyinvoice.domain.model.Invoice
import com.droidcon.tinyinvoice.domain.model.InvoiceWithItems
import com.droidcon.tinyinvoice.domain.model.Tax

fun GetInvoiceList.toInvoice(): InvoiceWithItems =
    InvoiceWithItems(
        invoice = Invoice(
            id = invoiceEntityId,
            businessId = businessEntityId.orZero(),
            customerId = customerEntityId.orZero(),
            taxId = taxEntityId.orZero(),
            isPaid = invoiceEntityIsPaid == TRUE,
        ),
        business = Business(
            id = businessEntityId.orZero(),
            name = businessEntityName.toString(),
            address = businessEntityAddress.toString(),
            phone = businessEntityPhone.toString(),
            email = businessEntityEmail.toString(),
        ),
        customer = Customer(
            id = customerEntityId.orZero(),
            name = customerEntityName.toString(),
            address = customerEntityAddress.toString(),
            phone = customerEntityPhone.toString(),
            email = customerEntityEmail.toString(),
        ),
        tax = Tax(
            id = taxEntityId.orZero(),
            desc = taxEntityDesc.toString(),
            value = taxEntityValue.orZero(),
        ),
    )