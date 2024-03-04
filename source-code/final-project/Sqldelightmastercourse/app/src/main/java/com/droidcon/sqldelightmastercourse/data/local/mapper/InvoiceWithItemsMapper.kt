package com.droidcon.sqldelightmastercourse.data.local.mapper

import com.droidcon.sqldelightmastercourse.domain.model.InvoiceWithItems

//fun InvoiceWithItemsEntity.toInvoiceWithItems(): InvoiceWithItems =
//    InvoiceWithItems(
//        invoice = invoiceDto.toInvoice(),
//        business = businessDto.toBusiness(),
//        customer = customerDto.toCustomer(),
//        tax = taxDto.toTax(),
//        items = items.map { it.toInvoiceItem() },
//    )
//
//fun InvoiceWithItems.toInvoiceWithItemsEntity(): InvoiceWithItemsEntity =
//    InvoiceWithItemsEntity(
//        invoiceDto = invoice.toInvoiceDto(),
//        businessDto = business.toBusinessDto(),
//        customerDto = customer.toCustomerDto(),
//        taxDto = tax.toTaxDto(),
//        items = items.map { it.toInvoiceItemDto() },
//    )
