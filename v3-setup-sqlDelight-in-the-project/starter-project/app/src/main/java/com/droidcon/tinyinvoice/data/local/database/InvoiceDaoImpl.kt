package com.droidcon.tinyinvoice.data.local.database

import com.droidcon.tinyinvoice.domain.model.InvoiceItem
import com.droidcon.tinyinvoice.domain.model.InvoiceWithItems
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InvoiceDaoImpl @Inject constructor() : InvoiceDao {

    override suspend fun addUpdateInvoice(
        businessId: Long,
        customerId: Long,
        taxId: Long,
        isPaid: Boolean
    ) = TODO()

    override suspend fun addUpdateInvoiceItem(
        desc: String,
        qty: Double,
        price: Double,
        invoiceId: Long,
    ) = TODO()

    override fun getInvoices(): Flow<List<InvoiceWithItems>> = TODO()

    override fun getInvoiceItems(invoiceId: Long): Flow<List<InvoiceItem>> = TODO()

    override fun getInvoiceTotalPrice(invoiceId: Long): Double = TODO()

    override suspend fun deleteInvoice(invoiceId: Long) = TODO()

    override suspend fun deleteInvoiceItem(invoiceItem: InvoiceItem) = TODO()

    override suspend fun setPaidStatus(invoiceId: Long, status: Boolean) = TODO()

    override fun lastInsertRowId() = TODO()

}