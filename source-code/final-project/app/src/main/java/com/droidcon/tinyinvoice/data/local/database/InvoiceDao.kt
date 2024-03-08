package com.droidcon.tinyinvoice.data.local.database

import com.droidcon.tinyinvoice.domain.model.InvoiceItem
import com.droidcon.tinyinvoice.domain.model.InvoiceWithItems
import kotlinx.coroutines.flow.Flow

interface InvoiceDao {
    suspend fun addUpdateInvoice(businessId: Long, customerId: Long, taxId: Long, isPaid: Boolean)
    suspend fun addUpdateInvoiceItem(desc: String, qty: Double, price: Double, invoiceId: Long,)
    fun getInvoices(): Flow<List<InvoiceWithItems>>
    fun getInvoiceItems(invoiceId: Long): Flow<List<InvoiceItem>>
    fun getInvoiceTotalPrice(invoiceId: Long): Double
    suspend fun deleteInvoice(invoiceId: Long)
    suspend fun deleteInvoiceItem(invoiceItem: InvoiceItem)
    suspend fun setPaidStatus(invoiceId: Long, status: Boolean)
    fun lastInsertRowId(): Long
}