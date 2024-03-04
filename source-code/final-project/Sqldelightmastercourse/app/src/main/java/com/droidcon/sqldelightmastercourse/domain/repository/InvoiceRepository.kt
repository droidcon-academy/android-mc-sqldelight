package com.droidcon.sqldelightmastercourse.domain.repository

import com.droidcon.sqldelightmastercourse.domain.model.InvoiceItem
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceWithItems
import kotlinx.coroutines.flow.Flow

interface InvoiceRepository {
    suspend fun addInvoice(businessId: Long, customerId: Long, taxId: Long, isPaid: Boolean)
    suspend fun addInvoiceItem(desc: String, qty: Double, price: Double, invoiceId: Long)

    suspend fun updateInvoice(businessId: Long, customerId: Long, taxId: Long, isPaid: Boolean)
    suspend fun updateInvoiceItem(desc: String, qty: Double, price: Double, invoiceId: Long)

    suspend fun deleteInvoice(id: Long)
    suspend fun deleteInvoiceItem(id: Long)

    fun getInvoices(): Flow<List<InvoiceWithItems>>
    fun getInvoiceItems(invoiceId: Long): Flow<List<InvoiceItem>>

    fun getInvoiceTotalPrice(invoiceId: Long): Double

    suspend fun setPaidStatus(invoiceId: Long, status: Boolean)
    fun lastInsertRowId(): Long
}